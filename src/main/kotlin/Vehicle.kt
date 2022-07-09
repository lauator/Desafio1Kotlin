import java.util.*
import java.util.concurrent.TimeUnit

//EJ 1, 2, 3, 4
data class Vehicle(val plate: String, val type: VehicleType, val checkInTime: Calendar, val discountCard : String? = null ){

    val parkedTime: Long get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / TimeUnit.MINUTES.toMillis(1)

    override fun equals(other: Any?): Boolean {

        if(other == null) return false

        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }

    override fun toString(): String {
        return "Vehicle(plate='$plate', type=$type, checkInTime=$checkInTime, discountCard=$discountCard)"
    }


}