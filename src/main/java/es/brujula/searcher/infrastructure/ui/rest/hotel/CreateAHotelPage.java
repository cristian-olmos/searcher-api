package es.brujula.searcher.infrastructure.ui.rest.hotel;

import es.brujula.searcher.application.command.hotels.create.CreateAHotelCommand;
import es.brujula.searcher.application.command.hotels.create.CreateAHotelCommandHandler;
import es.brujula.searcher.infrastructure.UuidGenerator;
import es.brujula.searcher.infrastructure.ui.rest.hotel.dto.HotelRequest;
import es.brujula.shared.CommandHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/hotels")
final class CreateAHotelPage {

    private final CommandHandler<CreateAHotelCommand> commandHandler;
    private final UuidGenerator uuidGenerator;

    CreateAHotelPage(CreateAHotelCommandHandler commandHandler, UuidGenerator uuidGenerator) {
        this.commandHandler = commandHandler;
        this.uuidGenerator = uuidGenerator;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@NotNull @Valid @RequestBody final HotelRequest hotel) {

        this.commandHandler.handle(
                new CreateAHotelCommand(
                        uuidGenerator.next(),
                        hotel.getName(),
                        hotel.getAddress(),
                        hotel.getCategory()
                )
        );
    }
}
