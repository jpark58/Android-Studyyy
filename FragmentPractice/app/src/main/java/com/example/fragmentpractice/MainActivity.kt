package com.example.fragmentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, ExampleFragment(), "example1")
                add(R.id.fragment_container_view, Example2Fragment(), "example2")
            }
        }

        val tv = findViewById<TextView>(R.id.tv)
        tv.setOnClickListener {
            val example2Fragment = supportFragmentManager.findFragmentByTag("example2")
            supportFragmentManager.commit {
                if(example2Fragment != null){
                    remove(example2Fragment)
                }else{
                    Toast.makeText(this@MainActivity, "더이상 존재하지 않아요!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}