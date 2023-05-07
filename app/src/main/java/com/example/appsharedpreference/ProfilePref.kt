package com.example.appsharedpreference

import android.content.Context
import android.content.SharedPreferences

class ProfilePref (context: Context) {
    companion object{
        const val SP_NAME = "profile_pref"
        const val NAMA = "nama"
        const val UMUR = "umur"
        const val JURUSAN = "jurusan"
        const val NPM = "NPM"
    }

    val preference = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

//    Membuat setter
    fun setProfile(profile: Profile){
        val prefEditor = preference.edit()
        prefEditor.putString(NAMA, profile.nama)
        profile.umur?.let { prefEditor.putInt(UMUR, it)}
        prefEditor.putString(JURUSAN, profile.jurusan)
        prefEditor.putString(NPM, profile.NPM)
        prefEditor.apply()
    }
//    Membuat getter
    fun getProfile(): Profile{
        val profile = Profile()
        profile.nama = preference.getString(NAMA,"")
        profile.umur = preference.getInt(UMUR, 0)
        profile.jurusan = preference.getString(JURUSAN, "")
        profile.NPM = preference.getString(NPM, "")
        return profile
    }
    
}