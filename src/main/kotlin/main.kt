import java.util.*

fun main(args: Array<String>) {

//EJ 5
 val car = Vehicle("AA111AA",VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001" )
 val moto = Vehicle("B222BBB",VehicleType.MOTORCYCLE, Calendar.getInstance())
 val minibus = Vehicle("CC333CC",VehicleType.MINIBUS, Calendar.getInstance())
 val bus = Vehicle("DD444DD",VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002" )
 val parking = Parking()

 parking.addVehicle(car)
 parking.addVehicle(moto)


 //println(parking.contains(car))

 parking.addVehicle(minibus)
 parking.addVehicle(bus)

 /*val car2 = Vehicle("AA111AA",VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001" )
 parking.addVehicle(car2)*/


//EJ 6

/*for(i in 0..20){
 val car = Vehicle("$i", VehicleType.CAR, Calendar.getInstance())
 parking.addVehicle(car)
}*/

 parking.listVehiclesByPlate()

 parking.checkOutVehicle(car.plate, { fee -> println("Your fee is ${fee}. Come back soon.")}, { println("Sorry, the check-out failed")})

 parking.checkOutVehicle(moto.plate, { fee -> println("Your fee is ${fee}. Come back soon.")}, { println("Sorry, the check-out failed")})

 parking.checkOutVehicle(minibus.plate, { fee -> println("Your fee is ${fee}. Come back soon.")}, { println("Sorry, the check-out failed")})



 parking.showEarnings()



 }








