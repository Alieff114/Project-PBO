class KonversiFahrenheit extends KonversiSuhu {
    @Override
    double konversiKeCelsius(double suhu) {
        return (suhu - 32) * 5 / 9;
    }

    @Override
    double konversiKeFahrenheit(double suhu) {
        return suhu;
    }

    @Override
    double konversiKeKelvin(double suhu) {
        return (suhu + 459.67) * 5 / 9;
    }
}