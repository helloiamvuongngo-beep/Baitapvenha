using System;

public class Vector2D
{
    public double X { get; private set; }
    public double Y { get; private set; }

    public Vector2D() : this(0, 0)
    {
    }

    public Vector2D(double x, double y)
    {
        X = x;
        Y = y;
    }

    public double DoDai => Math.Sqrt(X * X + Y * Y);

    public static Vector2D operator +(Vector2D a, Vector2D b)
        => new Vector2D(a.X + b.X, a.Y + b.Y);

    public static Vector2D operator -(Vector2D a, Vector2D b)
        => new Vector2D(a.X - b.X, a.Y - b.Y);

    public static Vector2D operator *(Vector2D v, double k)
        => new Vector2D(v.X * k, v.Y * k);

    public static Vector2D operator *(double k, Vector2D v)
        => v * k;

    public static double operator *(Vector2D a, Vector2D b)
        => a.X * b.X + a.Y * b.Y;

    public static Vector2D operator -(Vector2D v)
        => new Vector2D(-v.X, -v.Y);

    public static bool operator ==(Vector2D a, Vector2D b)
    {
        if (ReferenceEquals(a, b)) return true;
        if (a is null || b is null) return false;
        return a.X == b.X && a.Y == b.Y;
    }

    public static bool operator !=(Vector2D a, Vector2D b)
        => !(a == b);

    public static implicit operator Vector2D((double X, double Y) tuple)
        => new Vector2D(tuple.X, tuple.Y);

    public override bool Equals(object? obj)
    {
        if (obj is Vector2D other)
        {
            return X == other.X && Y == other.Y;
        }
        return false;
    }

    public override int GetHashCode()
    {
        return X.GetHashCode() ^ Y.GetHashCode();
    }

    public override string ToString()
        => $"({X:F2}, {Y:F2})";
}
