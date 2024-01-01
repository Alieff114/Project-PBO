class KonversiKelvin extends KonversiSuhu {
    @Override
    double konversiKeCelsius(double suhu) {
        return suhu - 273.15;
    }

    @Override
    double konversiKeFahrenheit(double suhu) {
        return (suhu * 9 / 5) - 459.67;
    }

    @Override
    double konversiKeKelvin(double suhu) {
        return suhu;
    }
}