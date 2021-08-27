package abc.com.recyclerviewuserinput

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
   lateinit var recyclerMain : RecyclerView
  lateinit var layoutmanger: RecyclerView.LayoutManager
 lateinit var btnSave: Button


    // lets declare array list
//    val bookList= arrayListOf(
//        "Main ", "second", "third", "fourth", "fifth", "sixth"
//    )

  val myList = ArrayList<String>()
    // declare variable for the adapter
    lateinit var recyclerAdapter: Adapter  // here Adapter is name of Adapter class
    // lateinit var editTaskName : EditText
    override fun onCreate(savedInstanceState: Bundle?) {

      //  val view= layoutInflater.inflate(R.layout.single_row, container, false )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerAdapter = Adapter(this, myList)  //  recycle Adapter
        recyclerMain= findViewById(R.id.recyclerMain)   // Recycler view
      layoutmanger= LinearLayoutManager(this)  // layout manager
    var editTaskName= findViewById <EditText>(R.id.editTaskName)
   btnSave= findViewById(R.id.btnSave)
        btnSave.setOnClickListener {
                myList.add(editTaskName.text.toString() )
        }


        //Now set layoutmanager and recycler Adapter with Recycler view
        recyclerMain.adapter= recyclerAdapter
        recyclerMain.layoutManager= layoutmanger


    }
    fun openNewTask(view: View) {
        startActivity(Intent(this,TaskActivity:: class.java))
    }
}