public class RadiusGlider {

    private int altitude; //in meters

    private int glide; //in meters

    /**
     * Constructor of the RadiusGlider class
     * @param altitude the altitude of the glider
     * @param glide the glide ratio of the glider
     */
    public RadiusGlider (int altitude, int glide) {
        this.altitude = altitude;
        this.glide = glide;
    }

    /**
     * Getter of the altitude attribute
     * @return the altitude of the glider
     */
    public int GetAltitude() {
        return this.altitude;
    }

    /**
     * Getter of the glide attribute
     * @return the glide ratio of the glider
     */
    public int GetGlide() {
        return this.glide;
    }

    /**
     * Setter of the altitude attribute
     * @param altitude the altitude of the glider
     */
    public void SetAltitude(int altitude) {
        this.altitude = altitude;
    }

    /**
     * Setter of the glide attribute
     * @param glide the glide ratio of the glider
     */
    public void SetGlide(int glide) {
        this.glide = glide;
    }

    /**
     * Takes the altitude and glide and returns the radius of the maximum distance possible in meters
     * @return the max radius in meters
     */
    public int GetMaxRadius () {
        int radius = this.altitude * this.glide;
        return radius;
    }

    /**
     * Takes the altitude and glide and returns the radius of the safe distance to get back to an airfield.
     * @return the safe radius in meters
     */
    public int GetSafeRadius () {
        int radius = this.altitude * this.glide - 200;
        return radius;
    }
}
