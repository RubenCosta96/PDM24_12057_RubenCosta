package com.example.navtest.presentation.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    fun registerUserWithFirebase(
        context: Context,
        email: String,
        password: String,
        confirmPassword: String,
        onSuccess: () -> Unit
    ) {
        if (password == confirmPassword) {
            viewModelScope.launch {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                context,
                                "Registo realizado com sucesso.",
                                Toast.LENGTH_SHORT
                            ).show()
                            onSuccess()
                        } else {
                            Toast.makeText(
                                context,
                                "Erro no registo: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        } else {
            Toast.makeText(
                context,
                "As senhas não coincidem.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}