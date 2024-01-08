class KonversiCelcius extends KonversiSuhu {
    @Override
    double konversiKeCelsius(double suhu) {
        return suhu;
    }

    @Override
    double konversiKeFahrenheit(double suhu) {
        return (suhu * 9 / 5) + 32;
    }

    @Override
    double konversiKeKelvin(double suhu) {
        return suhu + 273.15;
    }
}
