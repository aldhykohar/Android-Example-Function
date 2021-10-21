package com.aldhykohar.androidexamplefunction.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.aldhykohar.androidexamplefunction.databinding.ActivityMainBinding
import com.aldhykohar.androidexamplefunction.utils.CheckPermission.hasLocationForegroundPermission
import com.aldhykohar.androidexamplefunction.utils.CheckPermission.hasWriteExternalStoragePermission
import com.aldhykohar.androidexamplefunction.utils.CommonUtils.showToast

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            mbToast.setOnClickListener { showToast("This is Custom Toast") }
            mbPermission.setOnClickListener { requestPermission() }
        }
    }

    private fun requestPermission() {
        val permissionToRequest = mutableListOf<String>()
        if (!hasWriteExternalStoragePermission()) permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (!hasLocationForegroundPermission()) permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)

        if (permissionToRequest.isNotEmpty()) ActivityCompat.requestPermissions(
            this,
            permissionToRequest.toTypedArray(),
            0
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionRequest", "${permissions[i]} granted")
                }
            }
        }
    }

}