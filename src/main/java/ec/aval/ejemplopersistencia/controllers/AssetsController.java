package ec.aval.ejemplopersistencia.controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.aval.ejemplopersistencia.models.entity.Assets;
import ec.aval.ejemplopersistencia.models.services.IAssetsService;

@RestController
@RequestMapping("/api")
public class AssetsController {

	@Autowired
	private IAssetsService assetsService;

	@GetMapping("/assetss")
	public List<Assets> index() {
		return assetsService.findAll();
	}

	@GetMapping("/assetss/{id}")
	public Assets show(@PathVariable BigInteger tagId) {
		return this.assetsService.findById(tagId);
	}

	@PostMapping("/assetss")
	@ResponseStatus(HttpStatus.CREATED)
	public Assets create(@RequestBody Assets assets) {
		this.assetsService.save(assets);
		return assets;
	}

	@DeleteMapping("/assetss/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable BigInteger tagId) {
		Assets currentAssets = this.assetsService.findById(tagId);
		this.assetsService.delete(currentAssets);
	}
}
