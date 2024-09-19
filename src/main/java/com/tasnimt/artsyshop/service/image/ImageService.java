package com.tasnimt.artsyshop.service.image;

import com.tasnimt.artsyshop.dto.ImageDto;
import com.tasnimt.artsyshop.exception.ResourceNotFoundException;
import com.tasnimt.artsyshop.model.Image;
import com.tasnimt.artsyshop.repository.ImageRepo;
import com.tasnimt.artsyshop.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService {
    private final ImageRepo imageRepo;
    private final IProductService productService;


    @Override
    public Image getImageById(Long id) {
        return imageRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Image not found"));
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepo.findById(id).ifPresentOrElse(imageRepo::delete, () -> {
            throw new ResourceNotFoundException("Image not found");
        });

    }

    @Override
    public List<ImageDto> saveImages(Long productId, List<MultipartFile> files) {
        return null;

    }

    @Override
    public void updateImage(MultipartFile file, Long imageId) {


    }
}
