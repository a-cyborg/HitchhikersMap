package org.a_cyb.hitchhikersmap.api

val dummyHorizonApiResponseResults = listOf(
    // Mercury
    """
            *******************************************************************************
             Revised: April 12, 2021             Mercury                            199 / 1

             PHYSICAL DATA (updated 2021-Apr-12):
              Vol. Mean Radius (km) =  2440+-1        Density (g cm^-3)     = 5.427
              Mass x10^23 (kg)      =     3.302       Volume (x10^10 km^3)  = 6.085  
              Sidereal rot. period  =    58.6463 d    Sid. rot. rate (rad/s)= 0.00000124001
              Mean solar day        =   175.9421 d    Core radius (km)      = ~1600 
              Geometric Albedo      =     0.106       Surface emissivity    = 0.77+-0.06
              GM (km^3/s^2)         = 22031.86855     Equatorial radius, Re = 2440 km
              GM 1-sigma (km^3/s^2) =                 Mass ratio (Sun/plnt) = 6023682
              Mom. of Inertia       =     0.33        Equ. gravity  m/s^2   = 3.701     
              Atmos. pressure (bar) = < 5x10^-15      Max. angular diam.    = 11.0"   
              Mean Temperature (K)  = 440             Visual mag. V(1,0)    = -0.42 
              Obliquity to orbit[1] =  2.11' +/- 0.1' Hill's sphere rad. Rp = 94.4 
              Sidereal orb. per.    =  0.2408467 y    Mean Orbit vel.  km/s = 47.362 
              Sidereal orb. per.    = 87.969257  d    Escape vel. km/s      =  4.435
                                             Perihelion  Aphelion    Mean
              Solar Constant (W/m^2)         14462       6278        9126
              Maximum Planetary IR (W/m^2)   12700       5500        8000
              Minimum Planetary IR (W/m^2)   6           6           6
            *******************************************************************************


            *******************************************************************************
            Ephemeris / WWW_USER Sun May 28 18:57:11 2023 Pasadena, USA      / Horizons
            *******************************************************************************
            Target body name: Mercury (199)                   {source: DE441}
            Center body name: Sun (10)                        {source: DE441}
            Center-site name: BODY CENTER
            *******************************************************************************
            Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
            Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
            Step-size       : 720 minutes
            *******************************************************************************
            Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
            Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
            Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
            Output units    : KM-S
            Calendar mode   : Gregorian
            Output type     : GEOMETRIC cartesian states
            Output format   : 3 (position, velocity, LT, range, range-rate)
            Reference frame : Ecliptic of J2000.0
            *******************************************************************************
            JDTDB
               X     Y     Z
               VX    VY    VZ
               LT    RG    RR
            *******************************************************************************
            ${'$'}${'$'}SOE
            2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
             X = 5.309451938521343E+07 Y =-1.039776499152919E+06 Z =-4.955051862922415E+06
             VX=-8.456179380528084E+00 VY= 5.088163603739417E+01 VZ= 4.933696387070249E+00
             LT= 1.779076434180435E+02 RG= 5.333536971728280E+07 RR=-9.868292536420151E+00
            2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
             X = 5.268563421310535E+07 Y = 1.158560366159317E+06 Z =-4.737898528990939E+06
             VX=-1.047916510744039E+01 VY= 5.087919684056653E+01 VZ= 5.119055052435037E+00
             LT= 1.764918486367413E+02 RG= 5.291092511977264E+07 RR=-9.778857599245496E+00
            2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
             X = 5.218866878482742E+07 Y = 3.354945626631846E+06 Z =-4.512825535204273E+06
             VX=-1.253343844262607E+01 VY= 5.079061370775239E+01 VZ= 5.300243866039207E+00
             LT= 1.750902815879664E+02 RG= 5.249074588916858E+07 RR=-9.670710285156817E+00
            ${'$'}${'$'}EOE
            *******************************************************************************
    """,
    // Venus
    """
        *******************************************************************************
         Revised: April 12, 2021                Venus                           299 / 2
         
         PHYSICAL DATA (updated 2020-Oct-19):
          Vol. Mean Radius (km) =  6051.84+-0.01 Density (g/cm^3)      =  5.204
          Mass x10^23 (kg)      =    48.685      Volume (x10^10 km^3)  = 92.843
          Sidereal rot. period  =   243.018484 d Sid. Rot. Rate (rad/s)= -0.00000029924
          Mean solar day        =   116.7490 d   Equ. gravity  m/s^2   =  8.870
          Mom. of Inertia       =     0.33       Core radius (km)      = ~3200
          Geometric Albedo      =     0.65       Potential Love # k2   = ~0.25
          GM (km^3/s^2)         = 324858.592     Equatorial Radius, Re = 6051.893 km
          GM 1-sigma (km^3/s^2) =    +-0.006     Mass ratio (Sun/Venus)= 408523.72
          Atmos. pressure (bar) =  90            Max. angular diam.    =   60.2"
          Mean Temperature (K)  = 735            Visual mag. V(1,0)    =   -4.40
          Obliquity to orbit    = 177.3 deg      Hill's sphere rad.,Rp =  167.1
          Sidereal orb. per., y =   0.61519726   Orbit speed, km/s     =   35.021
          Sidereal orb. per., d = 224.70079922   Escape speed, km/s    =   10.361
                                         Perihelion  Aphelion    Mean
          Solar Constant (W/m^2)         2759         2614       2650
          Maximum Planetary IR (W/m^2)    153         153         153
          Minimum Planetary IR (W/m^2)    153         153         153
        *******************************************************************************


        *******************************************************************************
        Ephemeris / WWW_USER Sun May 28 19:37:14 2023 Pasadena, USA      / Horizons
        *******************************************************************************
        Target body name: Venus (299)                     {source: DE441}
        Center body name: Sun (10)                        {source: DE441}
        Center-site name: BODY CENTER
        *******************************************************************************
        Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
        Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
        Step-size       : 720 minutes
        *******************************************************************************
        Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
        Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
        Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
        Output units    : KM-S
        Calendar mode   : Gregorian
        Output type     : GEOMETRIC cartesian states
        Output format   : 3 (position, velocity, LT, range, range-rate)
        Reference frame : Ecliptic of J2000.0
        *******************************************************************************
        JDTDB
           X     Y     Z
           VX    VY    VZ
           LT    RG    RR
        *******************************************************************************
        ${'$'}${'$'}SOE
        2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
         X = 1.528464830751797E+07 Y = 1.066395510956085E+08 Z = 5.821245467342064E+05
         VX=-3.478579565567859E+01 VY= 4.792872223167582E+00 VZ= 2.073034585753873E+00
         LT= 3.593517006967541E+02 RG= 1.077309296383602E+08 RR=-1.798197240427163E-01
        2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
         X = 1.378043764710244E+07 Y = 1.068360336962475E+08 Z = 6.716190241373330E+05
         VX=-3.485243947665542E+01 VY= 4.303376752035970E+00 VZ= 2.070159751903215E+00
         LT= 3.593259454459831E+02 RG= 1.077232084084251E+08 RR=-1.776386628252352E-01
        2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
         X = 1.227349677757810E+07 Y = 1.070113490609552E+08 Z = 7.609804335258305E+05
         VX=-3.491219161934768E+01 VY= 3.812923927118208E+00 VZ= 2.066874103331880E+00
         LT= 3.593005070526743E+02 RG= 1.077155821699675E+08 RR=-1.754220410703930E-01
        ${'$'}${'$'}EOE
        *******************************************************************************
    """.trimIndent(),
    // Earth
    """
       *******************************************************************************
 Revised: April 12, 2021                 Earth                              399
 
 GEOPHYSICAL PROPERTIES (revised May 9, 2022):
  Vol. Mean Radius (km)    = 6371.01+-0.02   Mass x10^24 (kg)= 5.97219+-0.0006
  Equ. radius, km          = 6378.137        Mass layers:
  Polar axis, km           = 6356.752          Atmos         = 5.1   x 10^18 kg
  Flattening               = 1/298.257223563   oceans        = 1.4   x 10^21 kg
  Density, g/cm^3          = 5.51              crust         = 2.6   x 10^22 kg
  J2 (IERS 2010)           = 0.00108262545     mantle        = 4.043 x 10^24 kg
  g_p, m/s^2  (polar)      = 9.8321863685      outer core    = 1.835 x 10^24 kg
  g_e, m/s^2  (equatorial) = 9.7803267715      inner core    = 9.675 x 10^22 kg
  g_o, m/s^2               = 9.82022         Fluid core rad  = 3480 km
  GM, km^3/s^2             = 398600.435436   Inner core rad  = 1215 km
  GM 1-sigma, km^3/s^2     =      0.0014     Escape velocity = 11.186 km/s
  Rot. Rate (rad/s)        = 0.00007292115   Surface area:
  Mean sidereal day, hr    = 23.9344695944     land          = 1.48 x 10^8 km
  Mean solar day 2000.0, s = 86400.002         sea           = 3.62 x 10^8 km
  Mean solar day 1820.0, s = 86400.0         Love no., k2    = 0.299
  Moment of inertia        = 0.3308          Atm. pressure   = 1.0 bar
  Mean surface temp (Ts), K= 287.6           Volume, km^3    = 1.08321 x 10^12
  Mean effect. temp (Te), K= 255             Magnetic moment = 0.61 gauss Rp^3
  Geometric albedo         = 0.367           Vis. mag. V(1,0)= -3.86
  Solar Constant (W/m^2)   = 1367.6 (mean), 1414 (perihelion), 1322 (aphelion)
 HELIOCENTRIC ORBIT CHARACTERISTICS:
  Obliquity to orbit, deg  = 23.4392911  Sidereal orb period  = 1.0000174 y
  Orbital speed, km/s      = 29.79       Sidereal orb period  = 365.25636 d
  Mean daily motion, deg/d = 0.9856474   Hill's sphere radius = 234.9       
*******************************************************************************


*******************************************************************************
Ephemeris / WWW_USER Sun May 28 19:08:03 2023 Pasadena, USA      / Horizons
*******************************************************************************
Target body name: Earth (399)                     {source: DE441}
Center body name: Sun (10)                        {source: DE441}
Center-site name: BODY CENTER
*******************************************************************************
Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
Step-size       : 720 minutes
*******************************************************************************
Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
Output units    : KM-S
Calendar mode   : Gregorian
Output type     : GEOMETRIC cartesian states
Output format   : 3 (position, velocity, LT, range, range-rate)
Reference frame : Ecliptic of J2000.0
*******************************************************************************
JDTDB
   X     Y     Z
   VX    VY    VZ
   LT    RG    RR
*******************************************************************************
${'$'}${'$'}SOE
2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
 X =-1.486280750727092E+08 Y = 8.293543509286717E+06 Z = 7.822370334458537E+02
 VX=-2.153220385185046E+00 VY=-2.986389556285297E+01 VZ= 1.519457859192386E-03
 LT= 4.965411364690207E+02 RG= 1.488592878001611E+08 RR= 4.860394410576578E-01
2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
 X =-1.487154929264769E+08 Y = 7.003100926782971E+06 Z = 8.447504414548166E+02
 VX=-1.893868114319048E+00 VY=-2.987842144043627E+01 VZ= 1.374802373414141E-03
 LT= 4.966111979709947E+02 RG= 1.488802917100491E+08 RR= 4.863365701938693E-01
2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
 X =-1.487917025708406E+08 Y = 5.712082200850855E+06 Z = 9.010493908636272E+02
 VX=-1.634327999602640E+00 VY=-2.989056518123247E+01 VZ= 1.232191965410578E-03
 LT= 4.966812908411022E+02 RG= 1.489013050238669E+08 RR= 4.864771425182452E-01
${'$'}${'$'}EOE
******************************************************************************* 
    """.trimIndent(),
    // Mars
    """
        *******************************************************************************
         Revised: June 21, 2016                 Mars                            499 / 4
         
         PHYSICAL DATA (updated 2019-Oct-29):
          Vol. mean radius (km) = 3389.92+-0.04   Density (g/cm^3)      =  3.933(5+-4)
          Mass x10^23 (kg)      =    6.4171       Flattening, f         =  1/169.779
          Volume (x10^10 km^3)  =   16.318        Equatorial radius (km)=  3396.19
          Sidereal rot. period  =   24.622962 hr  Sid. rot. rate, rad/s =  0.0000708822 
          Mean solar day (sol)  =   88775.24415 s Polar gravity m/s^2   =  3.758
          Core radius (km)      = ~1700           Equ. gravity  m/s^2   =  3.71
          Geometric Albedo      =    0.150                                              

          GM (km^3/s^2)         = 42828.375214    Mass ratio (Sun/Mars) = 3098703.59
          GM 1-sigma (km^3/s^2) = +- 0.00028      Mass of atmosphere, kg= ~ 2.5 x 10^16
          Mean temperature (K)  =  210            Atmos. pressure (bar) =    0.0056 
          Obliquity to orbit    =   25.19 deg     Max. angular diam.    =  17.9"
          Mean sidereal orb per =    1.88081578 y Visual mag. V(1,0)    =  -1.52
          Mean sidereal orb per =  686.98 d       Orbital speed,  km/s  =  24.13
          Hill's sphere rad. Rp =  319.8          Escape speed, km/s    =   5.027
                                         Perihelion  Aphelion    Mean
          Solar Constant (W/m^2)         717         493         589
          Maximum Planetary IR (W/m^2)   470         315         390
          Minimum Planetary IR (W/m^2)    30          30          30
        *******************************************************************************


        *******************************************************************************
        Ephemeris / WWW_USER Sun May 28 19:38:16 2023 Pasadena, USA      / Horizons
        *******************************************************************************
        Target body name: Mars (499)                      {source: mar097}
        Center body name: Sun (10)                        {source: DE441}
        Center-site name: BODY CENTER
        *******************************************************************************
        Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
        Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
        Step-size       : 720 minutes
        *******************************************************************************
        Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
        Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
        Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
        Output units    : KM-S
        Calendar mode   : Gregorian
        Output type     : GEOMETRIC cartesian states
        Output format   : 3 (position, velocity, LT, range, range-rate)
        Reference frame : Ecliptic of J2000.0
        *******************************************************************************
        JDTDB
           X     Y     Z
           VX    VY    VZ
           LT    RG    RR
        *******************************************************************************
        ${'$'}${'$'}SOE
        2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
         X =-1.353939322213017E+08 Y = 2.043414462400678E+08 Z = 7.603762826510906E+06
         VX=-1.928221646053477E+01 VY=-1.132167412062855E+01 VZ= 2.357034963228921E-01
         LT= 8.180468899273177E+02 RG= 2.452442878905659E+08 RR= 1.219192833893723E+00
        2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
         X =-1.362257851983169E+08 Y = 2.038506359810022E+08 Z = 7.613881365128994E+06
         VX=-1.922944720153041E+01 VY=-1.140098281232061E+01 VZ= 2.327470182443121E-01
         LT= 8.182220340774062E+02 RG= 2.452967947858254E+08 RR= 1.211679326273041E+00
        2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
         X =-1.370553522985368E+08 Y = 2.033564048119553E+08 Z = 7.623872138920069E+06
         VX=-1.917638903972246E+01 VY=-1.148004941840397E+01 VZ= 2.297884840433020E-01
         LT= 8.183960944137501E+02 RG= 2.453489767618982E+08 RR= 1.204150352625298E+00
        ${'$'}${'$'}EOE
        *******************************************************************************
    
    """.trimIndent(),
    // Jupiter
    """
        *******************************************************************************
 Revised: April 12, 2021               Jupiter                              599
 
 PHYSICAL DATA:
  Mass x 10^22 (g)      = 189818722 +- 8817 Density (g/cm^3)  = 1.3262 +- .0003
  Equat. radius (1 bar) = 71492+-4 km       Polar radius (km)     = 66854+-10
  Vol. Mean Radius (km) = 69911+-6          Flattening            = 0.06487
  Geometric Albedo      = 0.52              Rocky core mass (Mc/M)= 0.0261
  Sid. rot. period (III)= 9h 55m 29.71 s    Sid. rot. rate (rad/s)= 0.00017585
  Mean solar day, hrs   = ~9.9259         
  GM (km^3/s^2)         = 126686531.900     GM 1-sigma (km^3/s^2) =  +- 1.2732
  Equ. grav, ge (m/s^2) = 24.79             Pol. grav, gp (m/s^2) =  28.34
  Vis. magnitude V(1,0) = -9.40
  Vis. mag. (opposition)= -2.70             Obliquity to orbit    =  3.13 deg
  Sidereal orbit period = 11.861982204 y    Sidereal orbit period = 4332.589 d
  Mean daily motion     = 0.0831294 deg/d   Mean orbit speed, km/s= 13.0697
  Atmos. temp. (1 bar)  = 165+-5 K          Escape speed, km/s    =  59.5           
  A_roche(ice)/Rp       =  2.76             Hill's sphere rad. Rp = 740
                                 Perihelion   Aphelion     Mean
  Solar Constant (W/m^2)         56           46           51
  Maximum Planetary IR (W/m^2)   13.7         13.4         13.6
  Minimum Planetary IR (W/m^2)   13.7         13.4         13.6
*******************************************************************************


*******************************************************************************
Ephemeris / WWW_USER Sun May 28 19:39:05 2023 Pasadena, USA      / Horizons
*******************************************************************************
Target body name: Jupiter (599)                   {source: jup365_merged}
Center body name: Sun (10)                        {source: jup365_merged}
Center-site name: BODY CENTER
*******************************************************************************
Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
Step-size       : 720 minutes
*******************************************************************************
Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
Output units    : KM-S
Calendar mode   : Gregorian
Output type     : GEOMETRIC cartesian states
Output format   : 3 (position, velocity, LT, range, range-rate)
Reference frame : Ecliptic of J2000.0
*******************************************************************************
JDTDB
   X     Y     Z
   VX    VY    VZ
   LT    RG    RR
*******************************************************************************
${'$'}${'$'}SOE
2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
 X = 6.995996087413136E+08 Y = 2.430374232515449E+08 Z =-1.666183980974297E+07
 VX=-4.442594767588359E+00 VY= 1.297037577886642E+01 VZ= 4.562240000161921E-02
 LT= 2.471042318677406E+03 RG= 7.407998505383186E+08 RR= 5.870545673943767E-02
2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
 X = 6.994074369369100E+08 Y = 2.435976789403395E+08 Z =-1.665986410940012E+07
 VX=-4.454217047413918E+00 VY= 1.296693637301979E+01 VZ= 4.582994811556507E-02
 LT= 2.471050704015783E+03 RG= 7.408023643995219E+08 RR= 5.755860953419359E-02
2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
 X = 6.992147926141950E+08 Y = 2.441577440945381E+08 Z =-1.665788044608217E+07
 VX=-4.464077012346461E+00 VY= 1.296208512226923E+01 VZ= 4.601580637060465E-02
 LT= 2.471058971242973E+03 RG= 7.408048428518821E+08 RR= 5.761065741356940E-02
${'$'}${'$'}EOE
*******************************************************************************
    """.trimIndent(),
    // Saturn
    """
   *******************************************************************************
 Revised: January 26, 2022             Saturn                               699
 
 PHYSICAL DATA:
  Mass x10^26 (kg)      = 5.6834          Density (g/cm^3)       =  0.687+-.001
  Equat. radius (1 bar) = 60268+-4 km     Polar radius (km)      = 54364+-10
  Vol. Mean Radius (km) = 58232+-6        Flattening             =  0.09796
  Geometric Albedo      = 0.47            Rocky core mass (Mc/M) =  0.1027
  Sid. rot. period (III)= 10h 39m 22.4s   Sid. rot. rate (rad/s) =  0.000163785 
  Mean solar day, hrs   =~10.656         
  GM (km^3/s^2)         = 37931206.234    GM 1-sigma (km^3/s^2)  = +- 98
  Equ. grav, ge (m/s^2) = 10.44           Pol. grav, gp (m/s^2)  = 12.14+-0.01
  Vis. magnitude V(1,0) = -8.88          
  Vis. mag. (opposition)= +0.67           Obliquity to orbit     = 26.73 deg
  Sidereal orbit period = 29.447498 yr    Sidereal orbit period  = 10755.698 d
  Mean daily motion     = 0.0334979 deg/d Mean orbit velocity    =  9.68 km/s
  Atmos. temp. (1 bar)  = 134+-4 K        Escape speed, km/s    =  35.5          
  Aroche(ice)/Rp        =  2.71           Hill's sphere rad. Rp  = 1100
                                 Perihelion  Aphelion    Mean
  Solar Constant (W/m^2)         16.8        13.6        15.1
  Maximum Planetary IR (W/m^2)    4.7         4.5         4.6
  Minimum Planetary IR (W/m^2)    4.7         4.5         4.6
*******************************************************************************


*******************************************************************************
Ephemeris / WWW_USER Sun May 28 19:40:05 2023 Pasadena, USA      / Horizons
*******************************************************************************
Target body name: Saturn (699)                    {source: sat441l}
Center body name: Sun (10)                        {source: DE441}
Center-site name: BODY CENTER
*******************************************************************************
Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
Step-size       : 720 minutes
*******************************************************************************
Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
Output units    : KM-S
Calendar mode   : Gregorian
Output type     : GEOMETRIC cartesian states
Output format   : 3 (position, velocity, LT, range, range-rate)
Reference frame : Ecliptic of J2000.0
*******************************************************************************
JDTDB
   X     Y     Z
   VX    VY    VZ
   LT    RG    RR
*******************************************************************************
${'$'}${'$'}SOE
2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
 X = 1.249696067466565E+09 Y =-7.703108147652690E+08 Z =-3.633954656546503E+07
 VX= 4.529013183815470E+00 VY= 8.215558958302033E+00 VZ=-3.224634369420776E-01
 LT= 4.898328913041383E+03 RG= 1.468482064933145E+09 RR=-4.473502198004829E-01
2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
 X = 1.249891678810259E+09 Y =-7.699558729442753E+08 Z =-3.635347604343259E+07
 VX= 4.527060136288274E+00 VY= 8.216948487992790E+00 VZ=-3.224272768724359E-01
 LT= 4.898264465055867E+03 RG= 1.468462743913153E+09 RR=-4.471557774458489E-01
2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
 X = 1.250087204761641E+09 Y =-7.696008695583597E+08 Z =-3.636740465665120E+07
 VX= 4.525060757608542E+00 VY= 8.218400290274364E+00 VZ=-3.224187936837719E-01
 LT= 4.898200039578025E+03 RG= 1.468443429640793E+09 RR=-4.470324889125236E-01
${'$'}${'$'}EOE
*******************************************************************************
  
    """.trimIndent(),
    // Uranus
    """
        *******************************************************************************
 Revised: September 30, 2021           Uranus                               799
 
 PHYSICAL DATA:
  Mass x10^24 (kg)      = 86.813          Density (g/cm^3)       =  1.271
  Equat. radius (1 bar) = 25559+-4 km     Polar radius (km)      = 24973+-20
  Vol. Mean Radius (km) = 25362+-12       Flattening             =  0.02293
  Geometric Albedo      = 0.51
  Sid. rot. period (III)= 17.24+-0.01 h   Sid. rot. rate (rad/s) = -0.000101237
  Mean solar day, h     =~17.24           Rocky core mass (Mc/M) =  0.0012        
  GM (km^3/s^2)         = 5793951.256     GM 1-sigma (km^3/s^2)  = +-4.3 
  Equ. grav, ge (m/s^2) =  8.87           Pol. grav, gp (m/s^2)  =   9.19+-0.02
  Visual magnitude V(1,0)= -7.11
  Vis. mag. (opposition)=  +5.52          Obliquity to orbit     = 97.77 deg
  Sidereal orbit period = 84.0120465 y    Sidereal orbit period  = 30685.4 d
  Mean daily motion     = 0.01176904 dg/d Mean orbit velocity    =  6.8 km/s
  Atmos. temp. (1 bar)  =  76+-2 K        Escape speed, km/s     =  21.3           
  Aroche(ice)/Rp        =  2.20           Hill's sphere rad., Rp = 2700
                                 Perihelion   Aphelion    Mean
  Solar Constant (W/m^2)         4.09         3.39        3.71
  Maximum Planetary IR (W/m^2)   0.72         0.55        0.63
  Minimum Planetary IR (W/m^2)   0.72         0.55        0.63
*******************************************************************************


*******************************************************************************
Ephemeris / WWW_USER Sun May 28 19:41:05 2023 Pasadena, USA      / Horizons
*******************************************************************************
Target body name: Uranus (799)                    {source: ura116}
Center body name: Sun (10)                        {source: ura116}
Center-site name: BODY CENTER
*******************************************************************************
Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
Step-size       : 720 minutes
*******************************************************************************
Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
Output units    : KM-S
Calendar mode   : Gregorian
Output type     : GEOMETRIC cartesian states
Output format   : 3 (position, velocity, LT, range, range-rate)
Reference frame : Ecliptic of J2000.0
*******************************************************************************
JDTDB
   X     Y     Z
   VX    VY    VZ
   LT    RG    RR
*******************************************************************************
${'$'}${'$'}SOE
2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
 X = 1.966707904305683E+09 Y = 2.186415779220212E+09 Z =-1.737351198825788E+07
 VX=-5.117698472078777E+00 VY= 4.250536986272532E+00 VZ= 8.211554645690566E-02
 LT= 9.809652051799943E+03 RG= 2.940859700733849E+09 RR=-2.628495113802799E-01
2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
 X = 1.966486809811138E+09 Y = 2.186599391524380E+09 Z =-1.736996563600433E+07
 VX=-5.118169036897684E+00 VY= 4.250037279472398E+00 VZ= 8.208107479689053E-02
 LT= 9.809614172918222E+03 RG= 2.940848344930791E+09 RR=-2.628862923088192E-01
2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
 X = 1.966265694621235E+09 Y = 2.186782982624244E+09 Z =-1.736641871727717E+07
 VX=-5.118632454358794E+00 VY= 4.249549458878613E+00 VZ= 8.214115671668543E-02
 LT= 9.809576288828315E+03 RG= 2.940836987566359E+09 RR=-2.629100010898814E-01
${'$'}${'$'}EOE
*******************************************************************************
    """.trimIndent(),
    // Neptune
    """
        *******************************************************************************
         Revised: April 22, 2021              Neptune                               899
         
         PHYSICAL DATA (update 2021-May-03):
          Mass x10^24 (kg)      = 102.409         Density (g/cm^3)       =  1.638
          Equat. radius (1 bar) = 24766+-15 km    Volume, 10^10 km^3     = 6254     
          Vol. mean radius (km) = 24624+-21       Polar radius (km)      = 24342+-30
          Geometric Albedo      = 0.41            Flattening             =  0.0171
          Sid. rot. period (III)= 16.11+-0.01 hr  Sid. rot. rate (rad/s) =  0.000108338 
          Mean solar day, h     =~16.11 h         
          GM (km^3/s^2)         = 6835099.97      GM 1-sigma (km^3/s^2)  = +-10 
          Equ. grav, ge (m/s^2) = 11.15           Pol. grav, gp (m/s^2)  = 11.41+-0.03
          Visual magnitude V(1,0)= -6.87
          Vis. mag. (opposition)=  +7.84          Obliquity to orbit     = 28.32 deg
          Sidereal orbit period = 164.788501027 y Sidereal orbit period  = 60189 d
          Mean daily motion     = 0.006020076dg/d Mean orbit velocity    =  5.43 km/s 
          Atmos. temp. (1 bar)  =  72+-2 K        Escape speed (1 bar)  =  23.5 km/s     
          Aroche(ice)/Rp        =  2.98           Hill's sphere rad., Rp = 4700
                                         Perihelion  Aphelion    Mean
          Solar Constant (W/m^2)         1.54        1.49        1.51
          Maximum Planetary IR (W/m^2)   0.52        0.52        0.52
          Minimum Planetary IR (W/m^2)   0.52        0.52        0.52
        *******************************************************************************


        *******************************************************************************
        Ephemeris / WWW_USER Sun May 28 19:41:57 2023 Pasadena, USA      / Horizons
        *******************************************************************************
        Target body name: Neptune (899)                   {source: nep102_merged}
        Center body name: Sun (10)                        {source: DE441}
        Center-site name: BODY CENTER
        *******************************************************************************
        Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
        Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
        Step-size       : 720 minutes
        *******************************************************************************
        Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
        Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
        Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
        Output units    : KM-S
        Calendar mode   : Gregorian
        Output type     : GEOMETRIC cartesian states
        Output format   : 3 (position, velocity, LT, range, range-rate)
        Reference frame : Ecliptic of J2000.0
        *******************************************************************************
        JDTDB
           X     Y     Z
           VX    VY    VZ
           LT    RG    RR
        *******************************************************************************
        ${'$'}${'$'}SOE
        2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
         X = 4.455279740709859E+09 Y =-4.043954076310107E+08 Z =-9.434793360419007E+07
         VX= 4.517303507510603E-01 VY= 5.460327346945967E+00 VZ=-1.221699859974275E-01
         LT= 1.492562530373125E+04 RG= 4.474589896992588E+09 RR=-4.112549793633220E-02
        2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
         X = 4.455299249810358E+09 Y =-4.041595212271500E+08 Z =-9.435321199873973E+07
         VX= 4.514687786528965E-01 VY= 5.460339681667429E+00 VZ=-1.221999851800883E-01
         LT= 1.492561937964999E+04 RG= 4.474588120997705E+09 RR=-4.109647515139915E-02
        2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
         X = 4.455318747615121E+09 Y =-4.039236342666883E+08 Z =-9.435849167022125E+07
         VX= 4.512074001001284E-01 VY= 5.460353115431841E+00 VZ=-1.222291032290472E-01
         LT= 1.492561345975620E+04 RG= 4.474586346258194E+09 RR=-4.106737874678710E-02
        ${'$'}${'$'}EOE
        *******************************************************************************
    """.trimIndent(),
    // Moon
    """
       *******************************************************************************
 Revised: July 31, 2013             Moon / (Earth)                          301
 
 GEOPHYSICAL DATA (updated 2018-Aug-15):
  Vol. mean radius, km  = 1737.53+-0.03    Mass, x10^22 kg       =    7.349
  Radius (gravity), km  = 1738.0           Surface emissivity    =    0.92
  Radius (IAU), km      = 1737.4           GM, km^3/s^2          = 4902.800066
  Density, g/cm^3       =    3.3437        GM 1-sigma, km^3/s^2  =  +-0.0001  
  V(1,0)                =   +0.21          Surface accel., m/s^2 =    1.62
  Earth/Moon mass ratio = 81.3005690769    Farside crust. thick. = ~80 - 90 km
  Mean crustal density  = 2.97+-.07 g/cm^3 Nearside crust. thick.= 58+-8 km 
  Heat flow, Apollo 15  = 3.1+-.6 mW/m^2   Mean angular diameter = 31'05.2"
  Heat flow, Apollo 17  = 2.2+-.5 mW/m^2   Sid. rot. rate, rad/s = 0.0000026617
  Geometric Albedo      = 0.12             Mean solar day        = 29.5306 d
  Obliquity to orbit    = 6.67 deg         Orbit period          = 27.321582 d
  Semi-major axis, a    = 384400 km        Eccentricity          = 0.05490
  Mean motion, rad/s    = 2.6616995x10^-6  Inclination           = 5.145 deg
  Apsidal period        = 3231.50 d        Nodal period          = 6798.38 d
                                 Perihelion  Aphelion    Mean
  Solar Constant (W/m^2)         1414+-7     1323+-7     1368+-7
  Maximum Planetary IR (W/m^2)   1314        1226        1268
  Minimum Planetary IR (W/m^2)      5.2         5.2         5.2
********************************************************************************


*******************************************************************************
Ephemeris / WWW_USER Sun May 28 19:43:19 2023 Pasadena, USA      / Horizons
*******************************************************************************
Target body name: Moon (301)                      {source: DE441}
Center body name: Sun (10)                        {source: DE441}
Center-site name: BODY CENTER
*******************************************************************************
Start time      : A.D. 2023-Mar-18 00:00:00.0000 TDB
Stop  time      : A.D. 2023-Mar-19 00:00:00.0000 TDB
Step-size       : 720 minutes
*******************************************************************************
Center geodetic : 0.0, 0.0, 0.0                   {E-lon(deg),Lat(deg),Alt(km)}
Center cylindric: 0.0, 0.0, 0.0                   {E-lon(deg),Dxy(km),Dz(km)}
Center radii    : 696000.0, 696000.0, 696000.0 km {Equator_a, b, pole_c}
Output units    : KM-S
Calendar mode   : Gregorian
Output type     : GEOMETRIC cartesian states
Output format   : 3 (position, velocity, LT, range, range-rate)
Reference frame : Ecliptic of J2000.0
*******************************************************************************
JDTDB
   X     Y     Z
   VX    VY    VZ
   LT    RG    RR
*******************************************************************************
${'$'}${'$'}SOE
2460021.500000000 = A.D. 2023-Mar-18 00:00:00.0000 TDB 
 X =-1.484171998446519E+08 Y = 7.998037806128753E+06 Z =-3.204614384345850E+04
 VX=-1.291060455303277E+00 VY=-2.921890399509991E+01 VZ= 5.700944838881838E-03
 LT= 4.957848197462768E+02 RG= 1.486325497508233E+08 RR=-2.831042323099692E-01
2460022.000000000 = A.D. 2023-Mar-18 12:00:00.0000 TDB 
 X =-1.484690925230164E+08 Y = 6.737696296020668E+06 Z =-3.154665622480679E+04
 VX=-1.113570772316266E+00 VY=-2.913153845378710E+01 VZ= 1.741202169565881E-02
 LT= 4.957492939989439E+02 RG= 1.486218993997080E+08 RR=-2.082409532349034E-01
2460022.500000000 = A.D. 2023-Mar-19 00:00:00.0000 TDB 
 X =-1.485135921893383E+08 Y = 5.480946898704473E+06 Z =-3.054427848541690E+04
 VX=-9.485579403521956E-01 VY=-2.905291530699341E+01 VZ= 2.894707909231897E-02
 LT= 4.957252762525849E+02 RG= 1.486146990604914E+08 RR=-1.235720504937045E-01
${'$'}${'$'}EOE
******************************************************************************* 
    """.trimIndent(),
)