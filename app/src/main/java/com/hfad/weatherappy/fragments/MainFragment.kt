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
import com.hfad.weatherappy.R
import com.hfad.weatherappy.databinding.FragmentMainBinding

class MainFragment : Fragment() {
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