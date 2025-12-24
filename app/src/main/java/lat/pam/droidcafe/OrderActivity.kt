package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // 1. Inisialisasi Spinner
        val spinner: Spinner = findViewById(R.id.city_spinner)

        // 2. Buat ArrayAdapter menggunakan string array dari strings.xml
        // Pastikan Anda sudah membuat <string-array name="city_array"> di strings.xml
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.city_array,
            android.R.layout.simple_spinner_item
        )

        // 3. Tentukan layout saat daftar pilihan muncul
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // 4. Terapkan adapter ke spinner dan set listener
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }

    // Fungsi untuk menangani pilihan pada Spinner
    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        val citySelected = parent.getItemAtPosition(position).toString()
        displayToast("Selected city: $citySelected")
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Tidak melakukan apa-apa
    }

    // Fungsi RadioButton yang sudah Anda miliki
    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked)
                displayToast(getString(R.string.same_day_messenger_service))

            R.id.nextday -> if (checked)
                displayToast(getString(R.string.next_day_ground_delivery))

            R.id.pickup -> if (checked)
                displayToast(getString(R.string.pick_up))

            else -> {}
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
