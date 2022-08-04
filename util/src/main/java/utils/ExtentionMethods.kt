package utils

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.PermissionChecker.*
import androidx.fragment.app.Fragment

private const val REQUEST_PERMISSION = 101

@RequiresApi(Build.VERSION_CODES.M)
fun Activity.verifyPermission(permissions: ArrayList<String>) {
    val permissionsNotYetGranted = arrayListOf<String>()
    for (i in permissions) {
        when (checkSelfPermission(this, i)) {
            PERMISSION_GRANTED -> {

            }
            PERMISSION_DENIED -> {
                toast("${i.split(".").last()} Permission Denied")
                permissionsNotYetGranted.add(i)
            }
            PERMISSION_DENIED_APP_OP -> {
                toast("${i.split(".").last()} Permission Denied by App")
                permissionsNotYetGranted.add(i)
            }
        }
    }

    requestPermissions(permissionsNotYetGranted)
}

fun Activity.requestPermissions(permissionsNotYetGranted:ArrayList<String>){
    if (permissionsNotYetGranted.size > 0){
        requestPermissions(this, permissionsNotYetGranted.toTypedArray(), REQUEST_PERMISSION)
    }
}

fun AppCompatActivity.transact(containerId:Int,fragment: Fragment){
    supportFragmentManager.beginTransaction()
        .add(containerId,fragment,fragment.tag)
        .commit()
}

fun AppCompatActivity.showConfirmExit(){
    val builder = AlertDialog.Builder(this.applicationContext)
    builder.setMessage("Are you sure you want to exit ?")
    builder.setTitle("Exit")
    builder.setCancelable(false)
    builder.setPositiveButton("Ok") { _, _ -> finish() }
    builder.setNegativeButton("Cancel"){dialog,_ -> dialog.dismiss()}
    builder.show()
}

fun AppCompatActivity.nextActivity(activity:Class<*>){
    startActivity(Intent(this,activity))
    finish()
}