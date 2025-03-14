package com.example.login_pakzul

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login_pakzul.databinding.ActivityMainBinding
//pembuat : Mas Fatur
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userAccounts = hashMapOf(
        "Fatur@gmail.com" to "password123",
        "Iqbal@gmail.com" to "pass456",
        "Havid@gmail.com" to "admin123",
        "Rohim@gmail.com" to "Rohim"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val email = binding.textEmail.text.toString().trim()
            val password = binding.textPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.textEmail.error = "Email must be filled"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.textPassword.error = "Password must be filled"
                return@setOnClickListener
            }

            if (userAccounts.containsKey(email)) {
                if (userAccounts[email] == password) {
                    Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this, "incorect password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "account not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
