package com.kotlinpractice.Test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.kotlinpractice.R
import com.kotlinpractice.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), OnClickListener {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("calling", "Frag_onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.d("calling", "Frag_onCreateView")
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.btnFrag.setOnClickListener(this)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("calling", "Frag_onAttach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("calling", "Frag_onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("calling", "Frag_onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("calling", "Frag_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("calling", "Frag_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("calling", "Frag_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("calling", "Frag_onStop")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("calling", "Frag_onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("calling", "Frag_onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("calling", "Frag_onDestroyView")
    }

    override fun onClick(v: View?) {
        if (v == binding.btnFrag) {
            activity?.let {
                val intent = Intent(it, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}