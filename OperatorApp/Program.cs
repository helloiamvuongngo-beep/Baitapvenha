using System;

public class Program
{
    public static void Main()
    {
        Console.OutputEncoding = System.Text.Encoding.UTF8;

        Console.WriteLine("=== BÀI TẬP 1: VECTOR2D ===");
        Vector2D v1 = new Vector2D(3, 4);
        Vector2D v2 = new Vector2D(1, 2);

        Console.WriteLine($"v1 = {v1}");
        Console.WriteLine($"v2 = {v2}");
        Console.WriteLine($"v1 + v2 = {v1 + v2}");
        Console.WriteLine($"v1 - v2 = {v1 - v2}");
        Console.WriteLine($"v1 * 2  = {v1 * 2}");
        Console.WriteLine($"3 * v2  = {3 * v2}");
        Console.WriteLine($"-v1    = {-v1}");
        Console.WriteLine($"|v1|   = {v1.DoDai:F4}");

        Console.WriteLine("\n--- Nâng cao Vector2D ---");
        Vector2D v3 = new Vector2D(3, 4);
        Console.WriteLine($"v1 == v3: {v1 == v3}");
        Console.WriteLine($"v1 != v2: {v1 != v2}");
        Console.WriteLine($"v1 * v2 (dot product) = {v1 * v2}");

        Vector2D vImplicit = (5.0, 6.0);
        Console.WriteLine($"Vector tu tuple: {vImplicit}");

        Console.WriteLine("\n=== BÀI TẬP 2: MONEY ===");
        Money luong = new Money(15_000_000, "VND");
        Money thuong = new Money(3_000_000, "VND");
        Money lamThemGio = luong * 1.5m;

        Console.WriteLine($"Luong co ban:   {luong}");
        Console.WriteLine($"Thuong thang:   {thuong}");
        Console.WriteLine($"Luong lam them: {lamThemGio}");
        Console.WriteLine($"Tong thu nhap:  {luong + thuong}");
        Console.WriteLine($"Luong > Thuong: {luong > thuong}");

        try
        {
            Money usd = new Money(100, "USD");
            Money tong = luong + usd;
        }
        catch (InvalidOperationException ex)
        {
            Console.WriteLine($"Loi: {ex.Message}");
        }

        Console.WriteLine("\n--- Nâng cao Money ---");
        Money usd100 = new Money(100, "USD");
        Money vndQuyDoi = Money.QuyDoi(usd100, "VND", 25500);
        Console.WriteLine($"Quy doi 100 USD sang VND: {vndQuyDoi}");

        Money a = new Money(100, "USD");
        Money b = new Money(100, "VND");
        Money c = new Money(100, "USD");
        Console.WriteLine($"100 USD == 100 VND: {a == b}");
        Console.WriteLine($"100 USD == 100 USD: {a == c}");

        Money tongHoaDon = new Money(1_000_000, "VND");
        Money phanCua1Nguoi = tongHoaDon / 4;
        Console.WriteLine($"Chia hoa don 1,000,000 VND cho 4: {phanCua1Nguoi}");
    }
}
