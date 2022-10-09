package com.gl4.tp1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class Exercise4 : AppCompatActivity() {
    lateinit var firstName : EditText
    lateinit var lastName : EditText
    lateinit var address : EditText
    lateinit var button: Button
    lateinit var sizeChoice : RadioGroup
    lateinit var sizeChoiceBtn : RadioButton
    lateinit var fromageBtn : CheckBox
    lateinit var thonBtn : CheckBox
    lateinit var pepperoniBtn : CheckBox
    lateinit var champignonBtn : CheckBox


    lateinit var firstNameTxt: String
    lateinit var lastNameTxt: String
    lateinit var addressTxt: String
    lateinit var sizeChoiceTxt: String
    lateinit var ingredients : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise4)
        firstName = findViewById(R.id.editTextFirstName)
        lastName = findViewById(R.id.editTextLastName)
        address = findViewById(R.id.address_edit_text)
        sizeChoice = findViewById(R.id.radioGroup)
        fromageBtn = findViewById(R.id.checkBox2)
        champignonBtn = findViewById(R.id.checkBox3)
        pepperoniBtn = findViewById(R.id.checkBox4)
        thonBtn=findViewById(R.id.checkBox5)
        firstNameTxt = firstName.text.toString()
        lastNameTxt = lastName.text.toString()
        addressTxt = address.text.toString()
        ingredients = ""
        button = findViewById(R.id.button)
        button.setOnClickListener{view->
            command(view)
        }
    }
    fun command(v: View){
        firstNameTxt = firstName.text.toString()
        lastNameTxt = lastName.text.toString()
        addressTxt = address.text.toString()
        sizeChoiceBtn = findViewById(sizeChoice.checkedRadioButtonId)
        sizeChoiceTxt = sizeChoiceBtn.text.toString()

        if(fromageBtn.isChecked){
            ingredients+= "Fromage, "
        }
        if(thonBtn.isChecked){
            ingredients+= "Thon, "
        }
        if(pepperoniBtn.isChecked){
            ingredients+= "pepperoni, "
        }
        if(champignonBtn.isChecked){
            ingredients+= "champignon, "
        }
        val message= "Name : $firstNameTxt \n " +
                "Last Name : $lastNameTxt \n" +
                "address: $addressTxt \n" +
                "size: $sizeChoiceTxt \n" +
                "ingredients : $ingredients \n"
        sendEmail("resto@gmail.com" , "new command" , message)
        Log.v("firstName",firstNameTxt)
        Log.v("lastName",lastNameTxt)
        Log.v("address",addressTxt)
        Log.v("size",sizeChoiceTxt)
        Log.v("ingredients",ingredients)
    }
    private fun sendEmail(recipient: String, subject: String, message: String) {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}