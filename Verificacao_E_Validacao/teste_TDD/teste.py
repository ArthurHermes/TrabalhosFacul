from unittest import TestCase, main

def calcular_area_retangulo(base, altura):
    return base * altura


class TestCalcularAreaRetangulo(TestCase):
    def test_area_retangulo(self):
        self.assertEqual(calcular_area_retangulo(5, 10), 50)
        self.assertEqual(calcular_area_retangulo(2, 3), 6)
        self.assertEqual(calcular_area_retangulo(0, 10), 0)
        self.assertEqual(calcular_area_retangulo(5, 0), 0)
        self.assertEqual(calcular_area_retangulo(7.5, 4), 30)

if __name__==    "__main__":
    main()