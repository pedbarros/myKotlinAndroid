package com.mykotlin.mykotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mykotlin.mykotlin.domain.User
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by pedro on 24/09/2017.
 */
class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnSave.setOnClickListener{
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString().toInt()
            val user = User(username, password)

            val intent = Intent()
            intent.putExtra(EXTRA_USER, user)
            setResult(RESULT_OK, intent)
            finish()

        }

    }

    companion object {
        val EXTRA_USER = "user"
    }
}