using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

#nullable disable

namespace TreningPrzedKolokwium.Models
{
    public partial class s20472Context : DbContext
    {
        public s20472Context()
        {
        }

        public s20472Context(DbContextOptions<s20472Context> options)
            : base(options)
        {
        }

        public virtual DbSet<Mieszkaniec> Mieszkaniecs { get; set; }
        public virtual DbSet<MieszkaniecPomieszczenie> MieszkaniecPomieszczenies { get; set; }
        public virtual DbSet<Pomieszczenie> Pomieszczenies { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasAnnotation("Relational:Collation", "Polish_CI_AS");

            modelBuilder.Entity<Mieszkaniec>(entity =>
            {
                entity.HasKey(e => e.Idclient)
                    .HasName("Mieszkaniec_pk");

                entity.ToTable("Mieszkaniec");

                entity.Property(e => e.Idclient)
                    .ValueGeneratedNever()
                    .HasColumnName("IDclient");

                entity.Property(e => e.DataUrodzenia).HasColumnType("datetime");

                entity.Property(e => e.Imie)
                    .IsRequired()
                    .HasMaxLength(20)
                    .IsUnicode(false);

                entity.Property(e => e.Nazwisko)
                    .IsRequired()
                    .HasMaxLength(20)
                    .IsUnicode(false);
            });

            modelBuilder.Entity<MieszkaniecPomieszczenie>(entity =>
            {
                entity.HasKey(e => new { e.MieszkaniecIdclient, e.PomieszczenieIdpomieszczenie })
                    .HasName("MieszkaniecPomieszczenie_pk");

                entity.ToTable("MieszkaniecPomieszczenie");

                entity.Property(e => e.MieszkaniecIdclient).HasColumnName("Mieszkaniec_IDclient");

                entity.Property(e => e.PomieszczenieIdpomieszczenie).HasColumnName("Pomieszczenie_IDpomieszczenie");

                entity.Property(e => e.DataWynajecia).HasColumnType("datetime");
            });

            modelBuilder.Entity<Pomieszczenie>(entity =>
            {
                entity.HasKey(e => e.Idpomieszczenie)
                    .HasName("Pomieszczenie_pk");

                entity.ToTable("Pomieszczenie");

                entity.Property(e => e.Idpomieszczenie)
                    .ValueGeneratedNever()
                    .HasColumnName("IDpomieszczenie");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
