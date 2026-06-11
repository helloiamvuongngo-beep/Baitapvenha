using System;

namespace PhanSoApp
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                PhanSo test1 = new PhanSo(2, 4);
                Console.WriteLine($"new PhanSo(2, 4) = {test1}");

                PhanSo test2 = new PhanSo(1, -3);
                Console.WriteLine($"new PhanSo(1, -3) = {test2}");

                try
                {
                    PhanSo test3 = new PhanSo(1, 0);
                }
                catch (ArgumentException e)
                {
                    Console.WriteLine($"Expected exception: {e.Message}");
                }

                PhanSo ps1 = new PhanSo(1, 2);
                PhanSo ps2 = new PhanSo(1, 3);

                Console.WriteLine($"ps1 = {ps1}");
                Console.WriteLine($"ps2 = {ps2}");
                Console.WriteLine($"ps1 + ps2 = {ps1 + ps2}");
                Console.WriteLine($"ps1 - ps2 = {ps1 - ps2}");
                Console.WriteLine($"ps1 * ps2 = {ps1 * ps2}");
                Console.WriteLine($"ps1 / ps2 = {ps1 / ps2}");

                Console.WriteLine($"ps1 + 2 = {ps1 + 2}");
                Console.WriteLine($"2 + ps1 = {2 + ps1}");

                PhanSo ps1Compare = new PhanSo(1, 2);
                PhanSo ps2Compare = new PhanSo(2, 4);
                PhanSo ps3Compare = new PhanSo(1, 3);

                Console.WriteLine(ps1Compare == ps2Compare);
                Console.WriteLine(ps1Compare != ps3Compare);
                Console.WriteLine(ps3Compare < ps1Compare);
                Console.WriteLine(ps1Compare > ps3Compare);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Unexpected error: {ex.Message}");
            }
        }
    }
}
