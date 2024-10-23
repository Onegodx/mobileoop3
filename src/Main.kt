// Класс первого уровня
open class MobilePhone(
    private val brand: String,
    private val price: Double,
    private val memory: Int // объем памяти в ГБ
) {

    // Метод для вычисления качества объекта Q
    open fun quality(): Double {
        return memory.toDouble() / price
    }

    // Метод для вывода информации об объекте
    open fun info(): String {
        return "Марка: $brand, Цена: $price, Объем памяти: $memory ГБ, Качество: ${quality()}"
    }
}

// Класс второго уровня
class DualSimMobilePhone(
    brand: String,
    price: Double,
    memory: Int,
    private val simCount: Int // количество SIM-карт
) : MobilePhone(brand, price, memory) {

    // Метод для вычисления качества объекта Qp
    override fun quality(): Double {
        return super.quality() * simCount
    }

    // Переопределение метода info для добавления информации о количестве SIM-карт
    override fun info(): String {
        return super.info() + ", Количество SIM-карт: $simCount, Качество с учетом SIM-карт: ${quality()}"
    }
}

fun main() {
    // Ввод значений для первого уровня
    println("Введите марку мобильного телефона:")
    val brand = readLine() ?: "Неизвестно"

    println("Введите цену мобильного телефона:")
    val price = readLine()?.toDoubleOrNull() ?: 0.0

    println("Введите объем памяти (ГБ):")
    val memory = readLine()?.toIntOrNull() ?: 0

    // Создание объекта класса MobilePhone
    val phone = MobilePhone(brand, price, memory)

    // Вывод информации об объекте первого уровня
    println(phone.info())

    // Ввод значений для второго уровня
    println("Введите количество SIM-карт:")
    val simCount = readLine()?.toIntOrNull() ?: 1

    // Создание объекта класса DualSimMobilePhone
    val dualSimPhone = DualSimMobilePhone(brand, price, memory, simCount)

    // Вывод информации об объекте второго уровня
    println(dualSimPhone.info())
}