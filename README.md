# Image Processing API

A simple Spring Boot project that applies basic image filters like **invert**, **solarize**, and **clip**.
You can upload an image, and the API will return the processed version instantly.

---

## Features

* **Invert Filter** → flips all image colors
* **Solarize Filter** → brightens dark parts while keeping bright parts unchanged
* **Clip Filter** → increases dark pixel values for better visibility

---

##  Endpoints

| Method | Endpoint                         | Description           |
| ------ | -------------------------------- | --------------------- |
| POST   | `/api/v1/images/filter/invert`   | Apply invert filter   |
| POST   | `/api/v1/images/filter/solarize` | Apply solarize filter |
| POST   | `/api/v1/images/filter/clip`     | Apply clip filter     |

All endpoints accept **multipart/form-data** with an image file parameter named `image`.

