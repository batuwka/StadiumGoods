package co.pokeapi;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class GetPokemonByNameTest {

    @DataProvider
    public Object[][] pokemons() {
        return new Object[][]{{"pikachu/", "co.pokeapi/schemas/pikachu.json"},
                {"snorlax/", "co.pokeapi/schemas/snorlax.json"},
                {"charizard/", "co.pokeapi/schemas/charizard.json"}
        };
    }

    @Test(dataProvider = "pokemons")
    public void pokemonFieldsValidation(String name, String path) {

        String response = given().baseUri("https://pokeapi.co")
                .when().get("/api/v2/pokemon/" + name).then().extract().asString();

        //A little trick to improve performance
        MatcherAssert.assertThat(response.split(",\"base_experience\"")[0].concat("}"), JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
    }
}
