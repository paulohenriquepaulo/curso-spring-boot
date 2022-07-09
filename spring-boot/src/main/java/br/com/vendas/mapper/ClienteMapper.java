package br.com.vendas.mapper;

import br.com.vendas.dto.ClienteBuscarDTO;
import br.com.vendas.dto.ClienteRequestDTO;
import br.com.vendas.dto.ClienteResponseDTO;
import br.com.vendas.dto.ClienteResquestAtualizarDto;
import br.com.vendas.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toCliente(ClienteRequestDTO clienteDTO);
    Cliente toCliente(ClienteBuscarDTO clienteBuscarDTO);

    Cliente toCliente(Cliente cliente);

    Cliente toCliente(ClienteResquestAtualizarDto clienteResquestAtualizarDto);

    ClienteResponseDTO toClienteResponseDto(Cliente cliente);

}
