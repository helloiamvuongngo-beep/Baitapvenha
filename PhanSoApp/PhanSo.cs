using System;

namespace PhanSoApp
{
    public class PhanSo
    {
        public int TuSo { get; private set; }
        public int MauSo { get; private set; }

        public PhanSo(int tuSo, int mauSo)
        {
            if (mauSo == 0)
                throw new ArgumentException("Mau so khong duoc bang 0!");

            if (mauSo < 0)
            {
                tuSo = -tuSo;
                mauSo = -mauSo;
            }

            int ucln = UCLN(Math.Abs(tuSo), mauSo);
            TuSo = tuSo / ucln;
            MauSo = mauSo / ucln;
        }

        private static int UCLN(int a, int b)
        {
            while (b != 0)
            {
                int t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

        public PhanSo RutGon()
        {
            return new PhanSo(TuSo, MauSo);
        }

        public override string ToString()
        {
            if (MauSo == 1) return TuSo.ToString();
            return $"{TuSo}/{MauSo}";
        }

        public static PhanSo operator +(PhanSo a, PhanSo b)
        {
            return new PhanSo(a.TuSo * b.MauSo + b.TuSo * a.MauSo, a.MauSo * b.MauSo);
        }

        public static PhanSo operator +(PhanSo a, int b)
        {
            return new PhanSo(a.TuSo + b * a.MauSo, a.MauSo);
        }

        public static PhanSo operator +(int a, PhanSo b)
        {
            return new PhanSo(a * b.MauSo + b.TuSo, b.MauSo);
        }

        public static PhanSo operator -(PhanSo a, PhanSo b)
        {
            return new PhanSo(a.TuSo * b.MauSo - b.TuSo * a.MauSo, a.MauSo * b.MauSo);
        }

        public static PhanSo operator *(PhanSo a, PhanSo b)
        {
            return new PhanSo(a.TuSo * b.TuSo, a.MauSo * b.MauSo);
        }

        public static PhanSo operator /(PhanSo a, PhanSo b)
        {
            if (b.TuSo == 0)
                throw new DivideByZeroException("Khong the chia cho phan so 0!");
            return new PhanSo(a.TuSo * b.MauSo, a.MauSo * b.TuSo);
        }

        public static bool operator ==(PhanSo? a, PhanSo? b)
        {
            if (ReferenceEquals(a, b)) return true;
            if (a is null || b is null) return false;
            return a.TuSo == b.TuSo && a.MauSo == b.MauSo;
        }

        public static bool operator !=(PhanSo? a, PhanSo? b)
        {
            return !(a == b);
        }

        public static bool operator <(PhanSo a, PhanSo b)
        {
            if (a is null || b is null) throw new ArgumentNullException();
            return a.TuSo * b.MauSo < b.TuSo * a.MauSo;
        }

        public static bool operator >(PhanSo a, PhanSo b)
        {
            if (a is null || b is null) throw new ArgumentNullException();
            return a.TuSo * b.MauSo > b.TuSo * a.MauSo;
        }

        public override bool Equals(object? obj)
        {
            if (obj is PhanSo other)
            {
                return this == other;
            }
            return false;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(TuSo, MauSo);
        }
    }
}
