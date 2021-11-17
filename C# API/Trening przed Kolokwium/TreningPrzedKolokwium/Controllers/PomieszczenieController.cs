using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TreningPrzedKolokwium.DTOs;
using TreningPrzedKolokwium.Interfaces;

namespace TreningPrzedKolokwium.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class PomieszczenieController : ControllerBase
    {

        private readonly IPomieszczenieService _dbservice;

        public PomieszczenieController(IPomieszczenieService service)
        {
            _dbservice = service;
        }

        [HttpPost] 
        public async Task<IActionResult> CreatePomieszczenie(CreatePomieszczenieDTO pomieszczenie)
        {
            return Ok(await _dbservice.AddPomieszczenie(pomieszczenie));
        }
        [HttpGet]
        public async Task<IActionResult> GetPomieszczenia()
        {
            return Ok(await _dbservice.getPomieszczenia());
        }
    }
}
