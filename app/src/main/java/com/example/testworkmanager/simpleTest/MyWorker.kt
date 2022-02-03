package com.example.testworkmanager.simpleTest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.testworkmanager.R

class MyWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {


    val notificationManager =
        applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // カテゴリー名（通知設定画面に表示される情報）
    val name = "通知のタイトル的情報を設定"

    // システムに登録するChannelのID
    val id = "casareal_chanel"

    // 通知の詳細情報（通知設定画面に表示される情報）
    val notifyDescription = "この通知の詳細情報を設定します"


    init {
        // Channelの取得と生成
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.getNotificationChannel(id) == null
            val mChannel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            mChannel.apply {
                description = notifyDescription
            }
            notificationManager.createNotificationChannel(mChannel)
        }
    }

    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        //uploadImages()

        repeat(10) {

            val notification = NotificationCompat.Builder(applicationContext, id).apply {

                setContentText("${it}回目のメッセージ")
                setSmallIcon(R.drawable.ic_launcher_background)
            }

            notificationManager.notify(1, notification.build())

            Thread.sleep(1000)
        }
        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    companion object {
        private const val TAG = "UploadWorker"
    }
}