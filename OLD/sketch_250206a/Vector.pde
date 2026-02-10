class Vector {
    private float x, y;

    // -------------------------------------------------------------------------------- //
    // Vector Class [ Private Variable Edition ] //
    // Created by mitgaa23 //
    // -------------------------------------------------------------------------------- //

    // -------------------------------------------------------------------------------- //
    // Guide //
    // -------------------------------------------------------------------------------- //
    /*
        There are methods named in the present => these change the vector directly.
        There are also methods which names are in past tense => these methods return a new vector.
        If there is only one value and the method has an alternative with two values,
            then it will redirect to the method with two values (both are the same)

        add(float):                 adds the float to both X and Y
        add(float, float):          adds the first float to X and the second float to Y
        add(Vector):                adds the values of the given vector with this vector
        added(...):                 equal to add(...) but returns a new vector

        subtract(float):            subtracts the float from both X and Y
        subtract(float, float):     subtracts the first float from X and the second float from Y
        subtract(Vector):           subtracts the values of the given vector from this vector
        subtracted(...):            equal to subtracted(...) but returns a new vector

        multiply(float):            multiplies the float with both X and Y
        multiply(float, float):     multiplies the first float with X and the second float with Y
        multiply(Vector):           multiplies the values of the given vector with this vector
        multiplied(...):            equal to multiply(...) but returns a new vector

        divide(float):              divides both X and Y values through the given value
        divide(float, float):       divides the X value through the first float
                                        and divides the Y value through the second float
        divide(Vector):             divides the X value through the givens vectors X value
                                        and the Y value through the given vectors Y value
        divided(...):               equal to divided(...) but returns a new vector

        project(float):             projects this vector's X and Y over the value
        project(float, float):      projects this vector's X with the first float
                                        and this vectors Y with the second float
        project(Vector):            projects this vector over the given vector
        projected(...):             equal to project(...) but returns a new vector

        rotate(float):              rotates the vector clockwise the given angle (in degrees)
        rotated(...):             equal to rotate(...) but returns a new vector
    */

    // -------------------------------------------------------------------------------- //
    // Constructors //
    // -------------------------------------------------------------------------------- //

    // Generates new Null-Vector
    public Vector() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    // Generates new Vector with X and Y values
    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Generates new Vector with random X and Y values between lower and upper
    public Vector(float xLower, float xUpper, float yLower, float yUpper) {
        this.x = rnd(xLower, xUpper);
        this.y = rnd(yLower, yUpper);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX() {
        this.x = x;
    }

    public void setY() {
        this.y = y;
    }

    // -------------------------------------------------------------------------------- //
	// Setter //
    // -------------------------------------------------------------------------------- //

	// Overrides this vector's X and Y values
	// Sets both X and Y to the given value
	public Vector set(float value) {
        return set(value, value);
    }

    // Overrides this vector's X and Y values
	// Sets the X and Y value to given vectors X and Y value
	public Vector set(Vector vect) {
		return set(vect.getX(), vect.getY());
	}

    // Overrides this vector's X and Y values
	// Sets this vector to the given X and Y values
    public Vector set(float x, float y) {
        this.x = x;
        this.y = y;
		return this;
    }

    // -------------------------------------------------------------------------------- //
	// Addition //
    // -------------------------------------------------------------------------------- //

	// Overrides this vector's X and Y values
	// Adds the value to both X and Y
	public Vector add(float value) {
		return add(value, value);
	}

    // Overrides this vector's X and Y values
	// Adds the given vector to this vector
	public Vector add(Vector vect) {
		return add(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	//  Adds the given value to this vector
	public Vector added(float value) {
        return clone().add(value, value);
    }

    // Returns a new vector with new values
	// Adds the given vector to this vector
    public Vector added(Vector vect) {
        return clone().add(vect.getX(), vect.getY());
    }

    // Returns a new vector with new values
	// Adds the given X and Y values to the vector
    public Vector added(float x, float y) {
        return clone().add(x, y);
    }

    // Overrides this vector's X and Y values
	// Adds the given X and Y values to the vector
	public Vector add(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}

    // -------------------------------------------------------------------------------- //
	// Subtraction //
    // -------------------------------------------------------------------------------- //

	// Overrides this vector's X and Y values
	// Subtracts the value from both X and Y
	public Vector subtract(float value) {
		return subtract(value, value);
	}

    // Overrides this vector's X and Y values
	// Subtracts the given vector form this vector
	public Vector subtract(Vector vect) {
		return subtract(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	// Adds the value to both X and Y
	public Vector subtracted(float value) {
        return clone().subtract(value, value);
    }

    // Returns a new vector with new values
	// Subtracts the given vector form this vector
    public Vector subtracted(Vector vect) {
        return clone().subtract(vect.getX(), vect.getY());
    }

    // Returns a new vector with new values
	// Subtracts the given X and Y values from the vector
    public Vector subtracted(float x, float y) {
        return clone().subtract(x, y);
    }

    // Overrides this vector's X and Y values
	// Subtracts the given X and Y values from the vector
	public Vector subtract(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

    // -------------------------------------------------------------------------------- //
	// Multiplication //
    // -------------------------------------------------------------------------------- //

	// Overrides this vector's X and Y values
	// Multiplies both X and Y with the given value
	public Vector multiply(float value) {
		return multiply(value, value);
	}

    // Overrides this vector's X and Y values
	// Multiplies this vector with the given vector
	public Vector multiply(Vector vect) {
        return multiply(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	// Subtracts the value from both X and Y
    public Vector multiplied(float value) {
        return clone().multiply(value, value);
    }

    // Returns a new vector with new values
	// Multiplies this vector with the given vector
    public Vector multiplied(Vector vect) {
        return clone().multiply(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	// Multiplies the given X and Y values with the vector
	public Vector multiplied(float x, float y) {
        return clone().multiply(x, y);
	}

    // Overrides this vector's X and Y values
	// Multiplies the given X and Y values with the vector
	public Vector multiply(float x, float y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

    // -------------------------------------------------------------------------------- //
	// Division //
    // -------------------------------------------------------------------------------- //

	// Overrides this vector's X and Y values
	// Divides both X and Y with the given value
	public Vector divide(float value) {
        value = 1 / value;
		return multiply(value, value);
	}

    // Overrides this vector's X and Y values
	// Divides this vector with the given vector
	public Vector divide(Vector vect) {
		return divide(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	// Multiplies both X and Y with the given value
    public Vector divided(float value) {
        value = 1 / value;
        return clone().multiply(value, value);
    }

    // Returns a new vector with new values
	// Divides this vector with the given vector
    public Vector divided(Vector vect) {
        return clone().divide(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	// Divides the vector with the given X and Y values
	public Vector divided(float x, float y) {
        return clone().divide(x, y);
	}

    // Overrides this vector's X and Y values
	// Divides the vector with the given X and Y values
	public Vector divide(float x, float y) {
		if (x != 0) this.x /= x;
		if (y != 0) this.y /= y;
		return this;
	}

    // -------------------------------------------------------------------------------- //
	// Projection //
    // -------------------------------------------------------------------------------- //

	// Overrides this vector's X and Y values
	// Projects the vector onto the given value (X and Y are the same)
	public Vector project(float value) {
		return project(value, value);
	}

    // Overrides this vector's X and Y values
	// Projects the vector onto the given vector
	public Vector project(Vector vect) {
		return project(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	// Projects the vector onto the given value (= X and Y)
	public Vector projected(float value) {
        return clone().project(value, value);
	}

    // Returns a new vector with new values
	// Projects the vector onto the other one
	public Vector projected(Vector vect) {
        return clone().project(vect.getX(), vect.getY());
	}

    // Returns a new vector with new values
	// Projects the vector onto the other one
	public Vector projected(float x, float y) {
        return clone().project(x, y);
	}

    // Overrides this vector's X and Y values
	// Projects the vector onto the given X and Y values
	public Vector project(float x, float y) {
		float scale = dot(x, y) / squaredMagnitude(x, y);
		float newX = scale * x;
		float newY = scale * y;
		this.x = newX;
		this.y = newY;
		return this;
	}


    // -------------------------------------------------------------------------------- //
	// Rotation //
    // -------------------------------------------------------------------------------- //

    // Returns a new vector with new values
	// Rotates the vector clockwise to the given degrees
	public Vector rotated(float degrees) {
        return clone().rotate(degrees);
	}

	// Overrides this vector's X and Y values
	// Rotates the vector clockwise to the given degrees
	public Vector rotate(float degrees) {
		float rad = degreeToRadian(degrees);
		float newX = (float) (this.x * Math.sin(rad) - this.y * Math.cos(rad));
		float newY = (float) (this.x * Math.cos(rad) + this.y * Math.sin(rad));
		this.x = newX;
		this.y = newY;
		return this;
	}

    // -------------------------------------------------------------------------------- //
	// Invertion //
    // -------------------------------------------------------------------------------- //

    // Returns a new vector with new values
	// Inverts / Multiplies both X and Y Values of this vector (with -1)
	public Vector inverted() {
        return clone().invert();
	}

	// Overrides this vector's X and Y values
	// Inverts / Multiplies both X and Y Values of this vector (with -1)
	public Vector invert() {
		this.x *= -1;
		this.y *= -1;
		return this;
	}

    // -------------------------------------------------------------------------------- //
	// Normalization //
    // -------------------------------------------------------------------------------- //

    // Returns a new vector with new values
	// Returns the normalized vector, if length is non-zero
    public Vector normalized() {
		return clone().normalize();
    }

	// Overrides this vector's X and Y values
	// Normalizes this Vector, if length is non-zero
	public Vector normalize() {
		float length = magnitude();

        if (length != 0) {
			float inversedLength = 1 / length;

			this.x *= inversedLength;
			this.y *= inversedLength;
        }

		return this;
	}

    // -------------------------------------------------------------------------------- //
	// Magnitude //
    // -------------------------------------------------------------------------------- //

	// Return the length / magnitude of this vector
    public float magnitude() { // length = magnitude
        return magnitude(this.x, this.y);
    }

	// Return the length / magnitude of the giben X and Y values
    public float magnitude(float value) { // length = magnitude
        return magnitude(value, value);
    }

	// Return the length / magnitude of the given vector
    public float magnitude(Vector vect) { // length = magnitude
        return magnitude(vect.getX(), vect.getY());
    }

	// Return the length / magnitude of the given X and Y values
    public float magnitude(float x, float y) { // length = magnitude
        return (float) Math.sqrt(x*x + y*y);
    }


    // -------------------------------------------------------------------------------- //
	// Squared Magnitude //
    // -------------------------------------------------------------------------------- //

	// Return the squared length / magnitude of this vector
    public float squaredMagnitude() {
        return squaredMagnitude(this.x, this.y);
    }

	// Return the squared length / magnitude of the given X and Y values
    public float squaredMagnitude(float value) { // length = magnitude
        return squaredMagnitude(value, value);
    }

	// Return the squared length / magnitude of the given vector
    public float squaredMagnitude(Vector vect) { // length = magnitude
        return squaredMagnitude(vect.getX(), vect.getY());
    }

	// Return the squared length / magnitude of the given X and Y values
	public float squaredMagnitude(float x, float y) {
        return x*x + y*y;
    }

    // -------------------------------------------------------------------------------- //
	// Dot-Product //
    // -------------------------------------------------------------------------------- //

    // Returns the dot product of this vector and the given value
    public float dot(float value) {
        return dot(value, value);
    }

	// Returns the dot product of this vector and the given vector
    public float dot(Vector vect) {
        return dot(vect.getX(), vect.getY());
    }

	// Returns the dot product of this vector and the given X and Y values
	public float dot(float x, float y) {
        return (this.x * x) + (this.y * y);
    }

    // -------------------------------------------------------------------------------- //
	// Distances //
    // -------------------------------------------------------------------------------- //

    public float getManhattanDistance(float value) {
        return getManhattanDistance(value, value);
    }

    public float getManhattanDistance(Vector vect) {
        return getManhattanDistance(vect.getX(), vect.getY());
    }

    public float getManhattanDistance(float x, float y) {
        return abs(this.x - x) + abs(this.y - y);
    }

    public float getDistance(float value) {
        return getDistance(value, value);
    }

    public float getDistance(Vector vect) {
        return getDistance(vect.getX(), vect.getY());
    }

    public float getDistance(float x, float y) {
        return (float) Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    // -------------------------------------------------------------------------------- //
    // Other Methods //
    // -------------------------------------------------------------------------------- //

	// Generates a random float value between Upper and Lower
	private float rnd(float lower, float upper) {
		return (float) (lower + (upper - lower) * Math.random());
	}

	// Returns a new Vector with same X and Y values
	public Vector clone() {
		return new Vector(this.x, this.y);
	}

	// Returns a new Vector with scaled X and Y values
	public Vector getCopy(float scaleValue) {
		return clone().multiply(scaleValue);
	}

	// -------------------------------------------------------------------------------- //
    // Convertion Methods //
    // -------------------------------------------------------------------------------- //

	// Returns the vector in string format
	public String toString() {
		String xString = String.format("%.5f", this.x);
		String yString = String.format("%.5f", this.y);
		return "(" + xString + " | " + yString + ")";
	}

	// Returns the given degree in radians
	public float degreeToRadian(float degrees) {
		return (float) (degrees * (Math.PI / 180));
	}
}
