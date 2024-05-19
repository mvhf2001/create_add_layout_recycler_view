package com.example.hello_world

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hello_world.MainActivity.Companion.USER
import com.example.hello_world.databinding.ActivityUserInfoForResultBinding

class UserInfoForResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserInfoForResultBinding
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserInfoForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpView()
    }

    private fun setUpView() {
        user = intent.getExtra<User>(USER)
        binding.btnUpdate.setOnClickListener {
            val phone = binding.edtPhone.text.toString()
            if (phone.isNotEmpty()) {
                user?.phone =  phone
                setResult(
                    Activity.RESULT_OK,
                    Intent().putExtra(USER, user)
                )
            } else {
                setResult(
                    Activity.RESULT_CANCELED
                )
            }
            finish()
        }
    }
}