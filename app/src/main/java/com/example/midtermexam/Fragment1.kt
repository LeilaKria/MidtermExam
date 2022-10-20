package com.example.midtermexam

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midtermexam.databinding.Fragment1Binding




class Fragment1 : Fragment(), View.OnClickListener {
    private lateinit var binding : Fragment1Binding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var registerUsernameInterface : RegisterUsernameInterface

    interface RegisterUsernameInterface{
        fun onSendData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        registerUsernameInterface = context as RegisterUsernameInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  Fragment1Binding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val charlength = binding.editTextUsername.text.length
        binding.editTextUsername.hint = "USERNAME"

        if(binding.editTextUsername.text.isEmpty()){
            binding.editTextUsername.error = "Required"
            return
        }
        else {
            val editor = sharedPreferences.edit()
            editor.putString(USER_NAME, binding.editTextUsername.text.toString())
            editor.apply()
            registerUsernameInterface.onSendData()
        }
    }
}