package com.example.homework

//noinspection SuspiciousImport

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.homework1.R
import kotlinx.android.synthetic.main.fragment.view.*



class MyFragment(index: Int) : Fragment() {
    private val index: Any = index

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment, container, false)
        view.textView.text = index.toString()
        return view
    }
}


class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: ViewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

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

