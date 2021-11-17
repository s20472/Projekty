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
    public class MieszkaniecController : ControllerBase
    {

        private readonly IMieszkaniecService _dbservice;

        public MieszkaniecController(IMieszkaniecService service)
        {
            _dbservice = service;
        }

        [HttpGet]
        public async Task<IActionResult> getMieszkancy()
        {
            return Ok(await _dbservice.GetMieszkancy());
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> deleteMieszkaniec([FromRoute]int id)
        {
            return Ok(await _dbservice.DeleteMieszkaniec(id));
        }

        [HttpPost]
        public async Task<IActionResult> createMieszkaniec(CreateMieszkaniecDTO mieszkaniec)
        {
            return Ok(await _dbservice.CreateMieszkaniec(mieszkaniec));
        }

        [HttpPut("{personID}")]
        public async Task<IActionResult> createMieszkaniec([FromRoute]int personID,[FromBody]int roomID)
        {
            return Ok(await _dbservice.RentPomieszczenie(personID,roomID));
        }
    }
}
