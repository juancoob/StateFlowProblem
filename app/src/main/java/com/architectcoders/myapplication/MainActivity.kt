package com.architectcoders.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.architectcoders.myapplication.MainViewModel.*
import com.architectcoders.myapplication.MainViewModel.PasswordState.*
import com.architectcoders.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                mainViewModel.passwordState.collect {
                    when (it) {
                        CHECK_PASSWORD_STATE -> {
                            //TODO logic not implemented for simplicity purposes
                            if (true) {
                                showPasswordDialogFragment(REQUEST_PASSWORD)
                            } else {
                                showPasswordDialogFragment(SAVE_PASSWORD)
                            }
                        }
                        SAVE_PASSWORD -> showPasswordDialogFragment(SAVE_PASSWORD)
                        REQUEST_PASSWORD -> showPasswordDialogFragment(REQUEST_PASSWORD)
                        REQUEST_HINT -> showPasswordDialogFragment(REQUEST_HINT)
                        SUCCESSFUL -> {
                            Toast.makeText(this@MainActivity, "yeah", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    private fun showPasswordDialogFragment(passwordState: PasswordState) {
        val passwordDialogFragment = PasswordDialogFragment.getInstance(passwordState)
        passwordDialogFragment.show(
            supportFragmentManager,
            PasswordDialogFragment::class.java.canonicalName
        )
    }
}