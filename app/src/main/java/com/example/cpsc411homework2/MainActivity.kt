//CPSC 411 Mobile Development
//Ryan Martinez

package com.example.cpsc411homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

open class MainActivity : AppCompatActivity() {

    lateinit var cService: ClaimService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val fldRowGenerator = FieldValueViewGenerator(this, "SSN")
        //val colGenerator = LableColumnGenerator(this)
        //val colView = colGenerator.generate()

        setContentView(R.layout.mainlayout)

        // gets ClaimService instance
        cService = ClaimService.getInstance(this)

        val claimTitle : EditText = findViewById(R.id.claim_title)
        val claimDate : EditText = findViewById(R.id.claim_date)
        val addButton : Button = findViewById(R.id.add_button)
        val statusMsg : TextView = findViewById(R.id.status_message)

        addButton.setOnClickListener {

            //check for empty spaces in the title and date fields
            if (TextUtils.isEmpty(claimTitle.text.toString()) || TextUtils.isEmpty(claimDate.text.toString())) {
                statusMsg.text = "Status: Some Fields Left Blank"
            }

            //if text fields are both occupied, take the content of the fields, create a claim, call
            //      the addClaim method, clear the text, and update the status message.
            else {

                var claim = Claim(claimTitle.text.toString(), claimDate.text.toString())
                cService.addClaim(claim)
                claimDate.text.clear()
                claimTitle.text.clear()
                statusMsg.text = "Status Message: Claim successfully added."
            }

        }

    }
}