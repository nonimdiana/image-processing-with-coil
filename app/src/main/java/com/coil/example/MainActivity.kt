package com.coil.example

import android.graphics.BlurMaskFilter
import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Transformation
import android.widget.ImageView
import android.widget.Toast
import coil.Coil
import coil.load
import coil.request.ImageRequest
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.coil.example.databinding.ActivityMainBinding
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClicks()
    }

    private fun updateState(newState: String) {
        binding.stateText.text = "State: $newState"
    }

    private fun handleClicks() {
        // Circle crop
        binding.circle.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.load(link) {
                transformations(
                    CircleCropTransformation()
                )
                build()
            }
            updateState("Circle Crop")
        }

        // Gray scale
        binding.grayScale.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.load(link) {
                transformations(
                    GrayscaleTransformation(),
                )
                build()
            }
            updateState("Grayscale")
        }

        // rounded
        binding.rounded.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.load(link) {
                transformations(
                    RoundedCornersTransformation(8F)
                )
                build()
            }
            updateState("Rounded")
        }

        // Blur
        binding.blur.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.load(link) {
                transformations(
                    BlurTransformation(this@MainActivity, radius = 8f),
                )
                build()
            }
            updateState("Blur")
        }

        // Cross fade
        binding.crossFade.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.load(link) {
                crossfade(750)
                build()
            }
            updateState("cross fade")
        }

        // place holder
        binding.placeholder.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.load(link) {
                placeholder(R.drawable.ic_placeholder)
                build()
            }
            updateState("Placeholder")
        }

        // Combined
        binding.combined.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.load(link) {
                crossfade(750)
                transformations(
                    CircleCropTransformation(),
                    GrayscaleTransformation() // e.t.c
                )
                build()
            }
            updateState("Combined State")
        }

        binding.crop.setOnClickListener {
            val link = ImageLinks().randomLink()
            binding.imageView.apply {
                load(link) {
                    size(240, 240)
                }
            }
        }

        binding.error.setOnClickListener {
            binding.imageView.load("https://a/bad/link") {
                listener(
                    onSuccess = { _, _ ->
                        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                    },
                    onError = { request: ImageRequest, throwable: Throwable ->
                        request.error
                        Toast.makeText(this@MainActivity, "$throwable", Toast.LENGTH_SHORT).show()
                    })
                // setup error image
                error(R.drawable.ic_error_image)
            }
        }
    }
}