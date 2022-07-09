import kotlin.math.ceil

class Parking() {

    val CUPO_MAXIMO = 20
    private val vehicles = mutableSetOf<Vehicle>()
    var registro: Pair<Int, Int> = Pair(0, 0)

// EJ 5
    fun addVehicle(vehiculo: Vehicle): Boolean {
        when {
            this.vehicles.contains(vehiculo) -> {
                println("The vehicle which plate is ${vehiculo.plate} is already in the parking")
                return false

            }
            this.vehicles.size < CUPO_MAXIMO -> {
                this.vehicles.add(vehiculo)
                println("Welcome to AlkeParking! ")
                return true
            }
            else -> {
                println("Sorry, the check-in failed")
                return false
            }
        }

    }

    fun showVehicles() {
        for (vehicle in vehicles) {
            println(vehicle)
        }
    }

    fun contains(vehicle: Vehicle) : Boolean{
        return vehicles.contains(vehicle)
    }

//EJ 7,10
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Unit, onError: () -> Unit) {
        val iterator = vehicles.iterator()
        while (iterator.hasNext()) {
            val vehicle = iterator.next()
            if (vehicle.plate == plate) {
                val fee = calculateFee(vehicle.type, vehicle.parkedTime, !vehicle.discountCard.isNullOrEmpty())
                onSuccess(fee)
                iterator.remove()
                registro = registro.copy(first = registro.first + 1)
                registro = registro.copy(second = registro.second + fee)
                return

            } else {
                onError()
            }
        }


    }

//EJ 8,9
    private fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        when (type.name) {
            VehicleType.CAR.name -> return calculate(type, parkedTime, hasDiscountCard)
            VehicleType.MOTORCYCLE.name -> return calculate(type, parkedTime, hasDiscountCard)
            VehicleType.MINIBUS.name -> return calculate(type, parkedTime, hasDiscountCard)
            VehicleType.BUS.name -> return calculate(type, parkedTime, hasDiscountCard)
        }
        return 0
    }

    private fun calculate(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        if (parkedTime <= 120) {
            if (hasDiscountCard) {
                return (type.fee - (type.fee * 0.15)).toInt()
            }
            return type.fee

        } else if (parkedTime > 120) {
            val minutesAfter120 = ((parkedTime - 120) / 15).toDouble()
            val minutesInt = ceil(minutesAfter120).toInt()
            val fee = type.fee + (5 * minutesInt)

            if (hasDiscountCard) {
                return (fee - (fee * 0.15)).toInt()
            }
        }

        return 0
    }

    //EJ 11
    fun showEarnings() {
        println("${registro.first} vehicles have checked out and have earnings of $${registro.second}")
    }

    //EJ 12
    fun listVehiclesByPlate() {
        for (vehicle in vehicles) {
            println(vehicle.plate)
        }
    }

}