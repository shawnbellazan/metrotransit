package com.tooensure.metrotransit.views.account

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.tooensure.metrotransit.model.MUser
import kotlinx.coroutines.launch

class AccountViewModel: ViewModel() {
    private val _loading = MutableLiveData(false)
    private val _auth: FirebaseAuth = Firebase.auth

    val loading: LiveData<Boolean> = _loading


    fun signInWithEmailAndPassword(email: String, password:String, home: () -> Unit
    ) = viewModelScope.launch {
        try {
            _auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { _task ->
                    if (_task.isSuccessful) home()
                    else Log.d("AUTH", "signInWithEmailAndPassword: ${_task.result.toString()}")
                }
        } catch (e: Exception) {
            Log.d("AUTH", "signInWithEmailPassword: ${e.message}")
        }
    }

    fun createUserWithEmailAndPassword(email: String, password:String, login: () -> Unit
    ) = viewModelScope.launch {
        try {
            _auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { _task ->
                    if (_task.isSuccessful) {
                        val displayName = _task.result?.user?.email?.split('@')?.get(0)
                        createUser(displayName)
                        login()
                    }
                    else Log.d("AUTH", "signInWithEmailAndPassword: ${_task.result.toString()}")
                }
        } catch (e: Exception) {
            Log.d("AUTH", "signInWithEmailPassword: ${e.message}")
        }
    }

    private fun createUser(displayName: String?) {
        val userId = _auth.currentUser?.uid

        val user = MUser(
            id = null,
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            age = "25"
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
    }

}