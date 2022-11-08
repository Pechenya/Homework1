package com.example.homework

//noinspection SuspiciousImport

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.homework1.MyViewModel
import com.example.homework1.R



class MyFragment(i: Int) : Fragment() {
    private val index: Any = i
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment, container, false)
        val text: TextView = view.findViewById(R.id.textView)
        text.setText(index.toString())
        return view
    }
}


class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: ViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        var i = 0
        button.setOnClickListener {
            var fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragment_container_view1, MyFragment(i))
            fragmentTransaction.commit()
            i++
        }
    }
}

