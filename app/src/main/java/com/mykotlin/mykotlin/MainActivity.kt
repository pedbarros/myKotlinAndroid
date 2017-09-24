package com.mykotlin.mykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mykotlin.mykotlin.domain.User
import com.mykotlin.mykotlin.extension.showShortToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val listUser : MutableList<User> by lazy { mutableListOf<User>() } // iniciando uma lista mutavel
    private var adapter : ArrayAdapter<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            startActivityForResult(intent, REQUEST_INSERT)
        }

        // renomeado para _ pois não está sendo utilizado
        listViewUser.setOnItemClickListener { _, _, position, _ ->
            showShortToast(listUser[position].username)
        }


        adapter = ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, listUser)
        listViewUser.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_INSERT && resultCode == RESULT_OK){
            val user = data?.getSerializableExtra(DetailActivity.EXTRA_USER) as? User

            if (user != null) {
                listUser.add(user)
                adapter?.notifyDataSetChanged()
            }
        }
    }

    //metodos ou variaveis estaticas da classe
    companion object {
        val REQUEST_INSERT = 0
    }
}
