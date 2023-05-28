package org.a_cyb.hitchhikersmap.util

import org.a_cyb.hitchhikersmap.models.CelestialBody
import org.a_cyb.hitchhikersmap.models.CelestialPosition
import org.a_cyb.hitchhikersmap.models.XYZVector
import org.a_cyb.hitchhikersmap.util.RegexPattern.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.jvm.Throws

@Throws
fun parseHorizonsApiResponses(results: List<String>): List<CelestialBody> {
    return results.map { parseHorizonsApiResponse(it) }.toList()
}

/**
 * Parse the long string response returned by Horizons Api.
 * If an error occurs, it sets the name to "Unknown" and the radius to 1f.
 *
 * @param response String
 * @return CelestialBody
 */
@Throws
private fun parseHorizonsApiResponse(response: String): CelestialBody {
    val name = NAME.pattern.find(response)?.groupValues?.get(1) ?: "Unknown"
    val radius = RADIUS.pattern.find(response)?.groupValues?.get(1)?.toFloat() ?: 1f
    val positions =
        POSITION.pattern.findAll(response).map { parsePosition(it) }.toList()

    return CelestialBody(name, radius, positions)
}

private fun parsePosition(position: MatchResult): CelestialPosition {
    val (rawDateAndTime, rawXyzVector) = position.destructured
    val dateAndTime = parseDateAndTime(rawDateAndTime)
    val xyz = parseXYZ(rawXyzVector)

    return CelestialPosition(dateAndTime, xyz)
}

private fun parseDateAndTime(dateAndTime: String): LocalDateTime {
    val dateTime = dateAndTime.dropLast(5)  // Drop the milliseconds.
    val formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss")

    return LocalDateTime.parse(dateTime, formatter)
}

private fun parseXYZ(xyz: String): XYZVector {
    val (x, y, z) =
        xyz.split(Regex("""(\w{1}\s?=\s*)""")).filter { it.isNotBlank() }

    return XYZVector(x.toFloat(), y.toFloat(), z.toFloat())
}

internal enum class RegexPattern(val pattern: Regex) {
    NAME(Regex("""(?:Target\s*body\s*name:\s*)(\w*)""")),
    RADIUS(Regex("""(?:Vol. [mM]ean [rR]adius,?\s*\(?km\)?\s*=\s*)(\d+)""")),
    POSITION(Regex("""(?:A.D.\s*)(\d{4}-\w+-\d{2}\s+\d{2}:\d{2}:\d{2}.\d{4})(?:\s*TDB\s*)(X\s*=\s*-?\d*.\d*E?\+?\d*\s*Y\s*=\s?-?\d*.\d*E\+?\d*\s*Z\s*=-?\d*\s*\d*.\d*E\+?\d*)""")),
}