package com.hfad.weatherappy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.weatherappy.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager //вызов менеджера фрагментов
            .beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance()) // функция замены того. что показывается во фрагменте (где показать, что показать(зд.Класс.Функция))
            .commit() // необходимо вызвать для применения нового фрагмента
    }

}