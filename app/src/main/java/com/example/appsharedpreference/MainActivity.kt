package com.example.appsharedpreference

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.appsharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var profilePref: ProfilePref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profilePref = ProfilePref(this)
        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvUmur = findViewById<TextView>(R.id.tvUmur)
        val tvJurusan = findViewById<TextView>(R.id.tvJrusan)
        val tvNPM = findViewById<TextView>(R.id.tvNama)

        // Bila sharedPreference memiliki nilai profile, maka akan ditampilkan
        if(profilePref.preference.contains(ProfilePref.NAMA)){
            val profile = profilePref.getProfile()
            tvNama.text = profile.nama
            tvUmur.text = profile.umur.toString()
            tvJurusan.text = profile.jurusan
            tvNPM.text = profile.NPM

        }

        val btnEdit = findViewById<Button> (R.id.btnEdit)
        btnEdit.setOnClickListener{
            Intent(this,FormActivity2::class.java).also{
                startActivity(it)
            }
        }
    }

}