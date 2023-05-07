package com.example.appsharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity2 : AppCompatActivity() {

    private lateinit var profilePref: ProfilePref
    override fun onCreate(savedInstanceState: Bundle?) {

        val etNama = findViewById<EditText>(R.id.etNama)
        val etUmur = findViewById<EditText>(R.id.etUmur)
        val etJurusan = findViewById<EditText>(R.id.etJurusan)
        val etNPM = findViewById<EditText>(R.id.etNPM)
        val btnSave = findViewById<Button>(R.id.btnSave)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form2)

        profilePref = ProfilePref(this)

        if(profilePref.preference.contains(ProfilePref.NAMA)){
            val profile = profilePref.getProfile()
            etNama.setText(profile.nama)
            profile.umur?.let {etUmur.setText(it.toString())}
            etJurusan.setText(profile.jurusan)
            etNPM.setText(profile.NPM)
        }

        btnSave.setOnClickListener{
            val nama = etNama.text.toString().trim()
            val umur = etUmur.text.toString().trim()
            val jurusan = etJurusan.text.toString().trim()
            val NPM = etNPM.text.toString().trim()

            val profile = Profile(nama, umur.toInt(), jurusan, NPM)

            saveToPref(profile)
        }
    }

    private fun saveToPref(profile: Profile) {
        profilePref.setProfile(profile)
        Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show()
        Intent(this, MainActivity::class.java).also{
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }
}