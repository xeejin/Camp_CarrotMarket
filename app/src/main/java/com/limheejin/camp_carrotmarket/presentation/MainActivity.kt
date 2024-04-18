package com.limheejin.camp_carrotmarket.presentation

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.limheejin.camp_carrotmarket.R
import com.limheejin.camp_carrotmarket.data.ItemList
import com.limheejin.camp_carrotmarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter
    private var itemList = ItemList.dummyData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()
        binding.btnNotification.setOnClickListener { createNotification() }
    }

    private fun initRecyclerView() {
        itemAdapter = ItemAdapter(itemList)
        with(binding.rvItemList) {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun createNotification() {
        // Create Notification Channel
        val name = getString(R.string.notification_channel_name)
        val descriptionText = getString(R.string.notification_channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channelID = "CarrotMarket"
        val Channel = NotificationChannel(channelID, name, importance)
        Channel.description = descriptionText
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(Channel)

        // Create New Notification
        val myNotificationID = 1001
        var builder = NotificationCompat.Builder(this, channelID)
            .setSmallIcon(R.drawable.ic_carrot)
            .setContentTitle("두둥! 구매자 등장!")
            .setContentText("등록한 물건을 구매하고자 하는 분이 등장했어요!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        NotificationManagerCompat.from(this).notify(myNotificationID, builder.build())
    }

    override fun onBackPressed() {
        var builder = AlertDialog.Builder(this)
        val listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> finish()
                    DialogInterface.BUTTON_NEGATIVE -> dialog?.dismiss()
                }
            }
        }
        with(builder) {
            setTitle("종료")
            setMessage("정말 종료하시겠습니까?")
            setIcon(R.drawable.ic_carrot)
            setPositiveButton("확인", listener)
            setNegativeButton("취소", listener)
            show()
        }
    }
}
