package com.hfad.weatherappy.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.hfad.weatherappy.adapters.VpAdapter
import com.hfad.weatherappy.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    private val tList = listOf(
        "Hours"
    )
    private lateinit var plauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermision()
        init()
    }

    private fun init() = with(binding) {
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout, vp){
            tab, pos -> tab.text = tList[pos]
        }.attach()
    }

    private fun permisionListener() { // поверка в реальном времени на разрешения, дает юзер его или нет
        //в fun Extention.kt идет проверка на уже существующие разрешения
        plauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()) {
            Toast.makeText(activity, "Permision $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermision() { //проверка ранее выданного юзером разрешения
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permisionListener()
            plauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }//        если его нет, то запускаем fun permisionListener

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()

    }
}