using System;

public class Money
{
    public decimal Amount { get; private set; }
    public string Currency { get; private set; }

    public Money(decimal amount, string currency)
    {
        if (amount < 0)
            throw new ArgumentException("So tien khong the am!");
        Amount = amount;
        Currency = currency.ToUpper();
    }

    private static void KiemTraCungDonVi(Money a, Money b)
    {
        if (a.Currency != b.Currency)
            throw new InvalidOperationException(
                $"Khong the thuc hien phep toan giua {a.Currency} va {b.Currency}. " +
                $"Vui long quy doi ve cung don vi truoc.");
    }

    public static Money operator +(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        return new Money(a.Amount + b.Amount, a.Currency);
    }

    public static Money operator -(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        if (a.Amount < b.Amount)
            throw new InvalidOperationException("Ket qua tru khong duoc am!");
        return new Money(a.Amount - b.Amount, a.Currency);
    }

    public static Money operator *(Money m, decimal heSo)
    {
        if (heSo < 0)
            throw new ArgumentException("He so khong the am!");
        return new Money(m.Amount * heSo, m.Currency);
    }

    public static Money operator *(decimal heSo, Money m) => m * heSo;

    public static Money operator /(Money m, decimal divisor)
    {
        if (divisor == 0)
            throw new DivideByZeroException("Khong the chia cho 0!");
        if (divisor < 0)
            throw new ArgumentException("Bo so khong the am!");
        return new Money(m.Amount / divisor, m.Currency);
    }

    public static bool operator >(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        return a.Amount > b.Amount;
    }

    public static bool operator <(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        return a.Amount < b.Amount;
    }

    public static bool operator ==(Money a, Money b)
    {
        if (ReferenceEquals(a, b)) return true;
        if (a is null || b is null) return false;
        return a.Currency == b.Currency && a.Amount == b.Amount;
    }

    public static bool operator !=(Money a, Money b)
        => !(a == b);

    public static Money QuyDoi(Money nguon, string donViDich, decimal tyGia)
    {
        if (tyGia <= 0)
            throw new ArgumentException("Ty gia phai lon hon 0!");
        return new Money(nguon.Amount * tyGia, donViDich);
    }

    public override bool Equals(object? obj)
    {
        if (obj is Money other)
        {
            return Currency == other.Currency && Amount == other.Amount;
        }
        return false;
    }

    public override int GetHashCode()
    {
        return (Currency, Amount).GetHashCode();
    }

    public override string ToString()
        => $"{Amount:N0} {Currency}";
}
